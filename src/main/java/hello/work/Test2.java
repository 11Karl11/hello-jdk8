package hello.work;

/**
 * @author karl xie
 * Created on 2020-04-16 15:17
 */
public class Test2 {
    public static void main(String[] args) {
        // System.out.println(new Random().nextDouble() * 2);
        int coefficient = getCoefficient(1.0);
        System.out.println(coefficient);
    }

    private static int getCoefficient(Double abs) {
        int value = abs.intValue();
        return value > 0 && value <= 20 ? 1 : value > 20 && value <= 40 ? 2 : value > 40 && value <= 60 ? 3
                : value > 60 && value <= 80 ? 4 : value > 80 && value <= 100 ? 5 : value > 100 && value <= 120 ? 6
                : value > 120 && value <= 140 ? 7 : value > 140 && value <= 160 ? 8 : value > 160 && value <= 180 ? 9
                : value > 180 && value <= 200 ? 10 : value > 200 && value <= 220 ? 11 : value > 220 && value <= 240 ? 12
                : value > 240 && value <= 260 ? 13 : value > 260 && value <= 280 ? 14 : 15;
    }
}