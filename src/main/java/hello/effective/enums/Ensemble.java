package hello.effective.enums;

/**
 * @author karl xie
 * Created on 2022-01-05 10:34
 */
// Abuse of ordinal to derive an associated value - DON'T DO THIS
public enum Ensemble {
    SOLO(3), DUET, TRIO, QUARTET, QUINTET,SEXTET, SEPTET, OCTET, NONET, DECTET;

    private int a;

    Ensemble(int a) {
        this.a = a;
    }

    Ensemble() {
        this.a = 0;
    }

    public int numberOfMusicians() { return ordinal() + 1; }

    public static void main(String[] args) {
        System.out.println(SOLO.numberOfMusicians());
    }
}