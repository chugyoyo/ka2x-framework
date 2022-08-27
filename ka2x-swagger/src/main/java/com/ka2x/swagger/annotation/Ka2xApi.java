package com.ka2x.swagger.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *    启用此注解，方法识别成为一个api服务
 * </p>
 * @author ka2x
 * @since 2022/8/27 19:28
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ka2xApi {

    // description for the api
    String desc() default "";
}
