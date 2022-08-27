package com.ka2x.swagger.inca;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {

    int index();
}
