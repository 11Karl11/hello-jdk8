package hello.demo;

import java.util.Random;

/**
 * 其实，选择一组随机的整数并不是随机的
 * @author karl xie
 * Created on 2020-04-22 19:24
 */
public class TestRandom {
    public static void main(String[] args) {
        System.out.println(randomString(-229985452));
        System.out.println(randomString(-147909649));
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }
}