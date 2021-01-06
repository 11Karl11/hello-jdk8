package hello.advance.pattern.proxy.second.mybatis;

import java.lang.annotation.*;

/**
 * @author karl xie
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    String value();
}
