package hello.effective.others;

/**
 * @author karl xie
 * Created on 2021-12-28 12:36
 */
public class ClassOuter {

    Object object = new Object() {
        public void finalize() {
            System.out.println("inner Free the occupied memory...");
        }
    };

    public void finalize() {
        System.out.println("Outer Free the occupied memory...");
    }
}

class TestInnerClass {
    public static void main(String[] args) {
        try {
            Test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Test() throws InterruptedException {
        System.out.println("Start of program.");

        ClassOuter outer = new ClassOuter();
        Object object = outer.object;
        outer = null;

        System.out.println("Execute GC");
        System.gc();

        Thread.sleep(3000);
        System.out.println("End of program.");
    }
}

