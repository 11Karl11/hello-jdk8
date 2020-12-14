package hello.advance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleTwoReturn<A, B> {

    /**
     * 第一个返回值
     **/
    private A first;

    /**
     * 第二个返回值
     **/
    private B second;


}