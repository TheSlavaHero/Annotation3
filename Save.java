package com.company;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Save {
    String directory();
    boolean i() default  false;//0 - serialize, 1 - deserialize
}
