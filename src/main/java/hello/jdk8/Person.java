package hello.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/19 20:49
 * @Created karl xie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String username;

    private int age;
}

