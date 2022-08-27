package com.ka2x.swagger.inca;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Command {

    String value() default "";
}
