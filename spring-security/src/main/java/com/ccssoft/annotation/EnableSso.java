package com.ccssoft.annotation;

import com.ccssoft.config.SsoAuthenticationConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * <br>
 * Date 2019/1/14 20:33<br>
 * Author Administrator<br>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SsoAuthenticationConfig.class)
public @interface EnableSso {

}
