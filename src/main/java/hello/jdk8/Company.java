package hello.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/21 16:16
 * @Created karl xie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String name;

    private List<Employee> employees;
}
