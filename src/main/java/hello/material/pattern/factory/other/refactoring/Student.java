package hello.material.pattern.factory.other.refactoring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;

    private Integer age;
}