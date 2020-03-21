package hello.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/21 15:24
 * @Created karl xie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name="zhangsan";

    private int age=20;
}
