package hello.jdk8;

import java.util.Optional;

/**
 * @Description TODO
 * @Date 2020/3/21 16:00
 * @Created karl xie
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional=Optional.ofNullable(null);
//        if (optional.isPresent()){
//            System.out.println(optional.get());
//        }
        //标准的使用方法
        optional.ifPresent(item-> System.out.println(item));
        System.out.println("-------------");
        System.out.println(optional.orElse("world"));
        System.out.println("------------");
        System.out.println(optional.orElseGet(()->"nihao"));
    }
}
