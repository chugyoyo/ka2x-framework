package com.ka2x.swagger.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *    在SpringBoot启动类上添加此注解，以支持Ka2xApi
 * </p>
 * @author ka2x
 * @since 2022/8/27 20:19
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface EnableKa2xApi {

    String[] value() default {};

    // packages that need to scan
    String[] basePackages() default {};
}