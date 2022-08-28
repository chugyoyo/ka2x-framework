package com.ka2x.swagger.config;

import com.ka2x.common.util.ApplicationContextUtil;
import com.ka2x.swagger.annotation.EnableKa2xApi;
import com.ka2x.swagger.annotation.Ka2xApi;
import com.ka2x.swagger.aspect.Ka2xApiAspect;
import com.ka2x.swagger.inca.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;
import org.springframework.core.io.*;
import org.springframework.core.type.*;
import org.springframework.core.type.filter.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

@Slf4j
@Component
public class Ka2xApiRegister implements ImportBeanDefinitionRegistrar,
        ResourceLoaderAware, EnvironmentAware, BeanPostProcessor {

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;
    /**
     * 环境
     */
    private Environment environment;

    @SneakyThrows
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        // 创建scanner
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(resourceLoader);

        // 设置扫描器scanner扫描的过滤条件
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(Ka2xApi.class);
        scanner.addIncludeFilter(annotationTypeFilter);

        // 获取指定要扫描的basePackages
        Set<String> basePackages = getBasePackages(metadata);

        // 遍历每一个basePackages
        for (String basePackage : basePackages) {
            // 通过scanner获取basePackage下的候选类(有标@SimpleRpcClient注解的类)
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
            // 遍历每一个候选类，如果符合条件就把他们注册到容器
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    // verify annotated class is an interface
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    Assert.isTrue(annotationMetadata.isInterface(), "@Ka2xApi can only be specified on an interface");
                    // 获取@Ka2xApi注解的属性
                    Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(Ka2xApi.class.getCanonicalName());
                    // 注册到容器
                    registerKa2xApi(registry, annotationMetadata, attributes);
                    log.info("attributes -> {}", attributes);
                    log.info("annotationMetadata -> {}", annotationMetadata);
                    log.info("beanDefinition -> {}", beanDefinition);
                }
            }
        }
    }

    /**
     * 利用factoryBean创建代理对象，并注册到容器
     */
    private static void registerKa2xApi(BeanDefinitionRegistry registry,
                                        AnnotationMetadata annotationMetadata,
                                        Map<String, Object> attributes) throws Exception {
        // 类名（接口全限定名）
        String className = annotationMetadata.getClassName();
        // 创建SimpleRpcClientFactoryBean的BeanDefinition
        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(Ka2xApi.class);
        // 解析出@Ka2xApi的desc属性
        String desc = getDesc(attributes);
        if (!StringUtils.hasText(desc)) {
            throw new Exception();
        }
        log.info("desc -> {}", desc);

        // 给factoryBean添加属性值
        definition.addPropertyValue("desc", desc);
        definition.addPropertyValue("type", className);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        String alias = "Ka2xApi{\"" + desc + "\"}";
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
        // 注册bean定义信息到容器
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className, new String[]{alias});
        // 使用BeanDefinitionReaderUtils工具类将BeanDefinition注册到容器
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
    }

    /**
     * 创建扫描器
     */
    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    /**
     * 获取base packages
     */
    protected static Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        // 获取到@EnableKa2xApi注解所有属性
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableKa2xApi.class.getCanonicalName());
        Set<String> basePackages = new HashSet<>();
        assert attributes != null;
        // value 属性是否有配置值，如果有则添加
        for (String pkg : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        // basePackages 属性是否有配置值，如果有则添加
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        // 如果上面两步都没有获取到basePackages，那么这里就默认使用当前项目启动类所在的包为basePackages
        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }

        return basePackages;
    }


    /**
     * <p>
     * 当IOC容器中bean初始化完毕后执行
     * </p>
     *
     * @author ka2x
     * @since 2022/8/28 0:45
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Annotation[] annotations = bean.getClass().getAnnotationsByType(Ka2xApi.class);
        // 该bean不是Ka2xApi的bean
        if (annotations.length == 0) {
            return bean;
        }
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            log.info("method -> {}", method);
            Command[] incaCommands = method.getDeclaredAnnotationsByType(Command.class);
            // 该方法不是inca服务
            if (incaCommands.length == 0) {
                continue;
            }
            log.info("incaCommands -> {}", Arrays.toString(incaCommands));
            // 是inca服务
            Command command = incaCommands[0];
            String value = command.value();
            log.info("command value -> {}", value);
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                log.info("parameter -> {}", parameter.getName());
                Param[] params = parameter.getAnnotationsByType(Param.class);
                // 无@Param
                if (params.length == 0) {
                    log.info("no @param!");
                    continue;
                }
                // 有@Param
                int index = params[0].index();
                log.info("index -> {}", index);
                String parameterType = parameter.getType().toString();
                log.info("parameterType -> {}", parameterType);
            }
        }
        return bean;
    }

    protected static String getDesc(Map<String, Object> attributes) {
        return String.valueOf(attributes.get("desc"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
