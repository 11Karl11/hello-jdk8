package hello.effective.enums;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author karl xie
 * Created on 2021-12-28 11:49
 */
public class Test3 {

    // The int enum pattern - severely deficient!
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;
    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    public static void main(String[] args) {
        // String a = "1";
        // ((InterfaceTest1) () -> {
        //     System.out.println("test inner class" + a);
        // }).test();
        // dangerous(Lists.newArrayList("1"),Lists.newArrayList("2"));
        // String[] attributes = pickTwo("Good", "Fast", "Cheap");
        // int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;
        // System.out.println(i);
        // System.out.println(APPLE_FUJI == ORANGE_NAVEL);
        double x = 1.0;
        double y = 2.0;
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
    }


    static void dangerous(List<String>... stringLists) {
        // List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        System.out.println(objects[1]);
        // objects[0] = intList; // Heap pollution
        // String s = stringLists[0].get(0); // ClassCastException
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    public static void test(List<?> list) {
        list.forEach(o -> System.out.println(o));
    }


}