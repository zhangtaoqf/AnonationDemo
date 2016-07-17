package ztbd.qf.com.annotationdemo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/7/17.
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MField {
    int id();
}
