//package com.ka2x.demo.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.*;
//import org.springframework.core.env.*;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.boot.starter.autoconfigure.SwaggerUiWebMvcConfiguration;
//import springfox.boot.starter.autoconfigure.SwaggerUiWebMvcConfigurer;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//@EnableOpenApi
//@Slf4j
//@Configuration
//public class SwaggerConfig extends WebMvcConfigurationSupport {
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 解决静态资源无法访问
//        registry.addResourceHandler("/")
//                .addResourceLocations("classpath:/static/");
//        // 解决swagger无法访问
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        // 解决swagger的js文件无法访问
//        registry.addResourceHandler("/webjars/")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
////    @Bean
////    public Docket docket(Environment environment) {
////        //指定在dev/test环境下使用swagger
////        Profiles profiles = Profiles.of("dev", "test");
////        log.info("profiles -> {}", profiles);
////        boolean flag = environment.acceptsProfiles(profiles);
////        log.info("my profiles -> {}", Arrays.toString(environment.getActiveProfiles()));
////        return new Docket(DocumentationType.OAS_30)
////                .apiInfo(apiInfo())
//////                .pathMapping("swagger-ui.html")
////                .enable(true)//关闭swagger,默认是true
////                .select()
////                //RequestHandlerSelectors：配置要扫描的方式，有basePackage("路径")、any():扫描全部，none():全部不扫描
////                //RequestHandlerSelectors.withMethodAnnotation():扫描方法上的注解
////                //.withClassAnnotation()：扫描类上的注解
////                .apis(RequestHandlerSelectors.basePackage("com.ka2x.demo.controller"))//指定扫描的包
//////                .paths(PathSelectors.ant("/**"))//设置请求路径，这里是带有hello的请求路径
////                .paths(PathSelectors.any())
////                .build()
////                ;
////    }
////
////    private ApiInfo apiInfo() {
////        Contact contact = new Contact("ka2x", "https://api.ka2x.com", "15815179079@163.com");
////        return new ApiInfo(
////                "ka2x api support",
////                "Api Documentation",
////                "v0.2",
////                "https://api.ka2x.com/terms",
////                contact,
////                "Apache 2.0",
////                "http://www.apache.org/licenses/LICENSE-2.0",
////                new ArrayList<>()
////        );
////    }
//}
