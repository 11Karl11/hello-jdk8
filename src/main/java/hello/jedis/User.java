package hello.jedis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author karl xie
 */
@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String name;

    private Integer age;
}