package com.base.anno;

import java.lang.annotation.*;

/**
 * 基础权限的检查
 *  todo:暂未做全面的考虑，方法级校验即接口校验
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {
    String type() default "";
}
