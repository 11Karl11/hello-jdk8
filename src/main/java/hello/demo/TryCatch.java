package hello.demo;

/**
 * 在catch中有return的情况下,finally中的内容还是会执行，并且是先执行finally再return。
 *
 *
 * 需要注意的是，如果返回的是一个基本数据类型，则finally中的内容对返回的值没有影响。因为返回的是	finally执行之前生成的一个副本。
 *
 *
 * 当catch和finally都有return时，return的是finally的值。
 *
 * @author karl xie
 * Created on 2020-04-21 09:53
 */
public class TryCatch {


    public static void main(String[] args) {
        //System.out.println("数值:" + two(8));
        System.out.println("---------------");
        System.out.println("数值:" + five(5));

    }

    public static int two(int i) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            System.out.println("return~~~~~~~");
            return i;
        } finally {
            System.out.println("finally~~~");
        }
    }

    public static int three(int i) {
        try {
            throw new Exception("异常");

        } catch (Exception e) {
            System.out.println("return~~~~");
            return 2;
        } finally {
            System.out.println("finally~~~");
            return 3;
        }
    }


    public static int four(int i) {
        try {
            throw new Exception("异常");

        } catch (Exception e) {
            System.out.println("return~~~~");
            return i;
        } finally {
            ++i;
            System.out.println("finally~~~");
        }
    }

    public static int five(int i) {
        try {
            throw new Exception("异常");

        } catch (Exception e) {
            System.out.println("return~~~~");
            return i;
        } finally {
            System.out.println("finally~~~");
            ++i;
            return i;
        }
    }
}