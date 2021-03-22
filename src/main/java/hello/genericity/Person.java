package hello.genericity;

import lombok.Data;

/**
 * 如果说不知道name和address的类型的时候，这个时候可以使用类型
 * 占位符来进行占位。
 * 定义泛型类
 * 将现在代码中所有的特定类型换成类型占位符T W  E...
 *
 * @author karl xie
 */
@Data
public class Person<T> {

    private T name;

    private T address;


}