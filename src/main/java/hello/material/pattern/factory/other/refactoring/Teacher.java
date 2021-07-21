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
public class Teacher {

    private String classroom;

    private String address;

}