package hello.advance.pattern.proxy.second.mybatis;

import java.util.List;

/**
 * @author karl xie
 */
public interface MyBatis {

    @Select("select * from demo")
    List<String> select();
}
