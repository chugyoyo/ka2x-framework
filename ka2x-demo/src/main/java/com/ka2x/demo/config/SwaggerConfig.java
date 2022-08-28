package com.ka2x.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Configuration
@EnableOpenApi
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        //指定在dev/test环境下使用swagger
        Profiles profiles = Profiles.of("dev", "test");
        log.info("profiles -> {}", profiles);
        boolean flag = environment.acceptsProfiles(profiles);
        log.info("my profiles -> {}", Arrays.toString(environment.getActiveProfiles()));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("swagger-ui.html")
                .enable(true)//关闭swagger,默认是true
                .select()
                //RequestHandlerSelectors：配置要扫描的方式，有basePackage("路径")、any():扫描全部，none():全部不扫描
                //RequestHandlerSelectors.withMethodAnnotation():扫描方法上的注解
                //.withClassAnnotation()：扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.ka2x.demo.controller"))//指定扫描的包
//                .paths(PathSelectors.ant("/**"))//设置请求路径，这里是带有hello的请求路径
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("ka2x", "https://www.ka2x.com", "15815179079@163.com");
        return new ApiInfo(
                "ka2x api demo",
                "Api Documentation",
                "v0.2",
                "http://172.16.1.186",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
