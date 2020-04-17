package hello.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/22 20:19
 * @Created karl xie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int score;
    private int age;

}
