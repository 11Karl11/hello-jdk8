package hello.advance.others;

/**
 * @author karl xie
 */
public class MultipleThreeReturn<A, B, C> extends MultipleTwoReturn {

    /**
     * 第三个返回值
     **/
    private C third;

    public MultipleThreeReturn(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

}