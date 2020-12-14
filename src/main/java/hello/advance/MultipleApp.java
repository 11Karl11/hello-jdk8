package hello.advance;

/**
 * @author karl xie
 */
public class MultipleApp {

    public static void main(String[] args) {
        MultipleTwoReturn<Integer, String> returnTest = MultipleApp.getReturnTest();
        System.out.println(returnTest.getFirst());
        System.out.println(returnTest.getSecond());
    }

    private static MultipleTwoReturn<Integer, String> getReturnTest() {
        MultipleTwoReturn<Integer, String> demo = new MultipleTwoReturn<>(0, "Demo");
        return demo;
    }

}