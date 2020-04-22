package hello.demo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-04-21 13:17
 */
@Data
@Builder
public class A<R,T> {

    Class<T> clazz;

    public A() {
    }

    public A(Class<T> clazz) {
        this.clazz = clazz;
    }
}