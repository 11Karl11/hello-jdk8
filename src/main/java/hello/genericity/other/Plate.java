package hello.genericity.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 */
@Data
@NoArgsConstructor
// @AllArgsConstructor
public class Plate<T> {

    T items;

    public Plate(T items) {
        this.items = items;
    }
}