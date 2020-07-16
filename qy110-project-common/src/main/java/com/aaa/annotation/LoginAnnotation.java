package com.aaa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 郭航宇
 * @Date 16:24 2020/7/15
 * Description:
 *  @Target():
 *         标识了自己所自定义注解的使用范围(也就是说标识了自定义使用于方法，类，属性...)
 *  @Retention():
 *        标识了自定义注解所生效的时间
 *          RUNTIME:项目运行的时候该自定义生效
 *          TEST:在有junit的时候生效
 *  @Inherited:
 *         继承(当该注解的时候，自定义的作用范围必须是类)
 *
 *
 *   自定义注解只是起到一个标识作用
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {
    /**
     * 要执行的操作类型:
     *      eg:
     *          delete操作，update操作，insert操作...
     * @return
     */
    String opeationType();

    /**
     * 所要执行的具体操作内容
     *      eg:
     *          删除用户，删除菜单，删除部门...
     * @return
     */
    String opeationName();

}
