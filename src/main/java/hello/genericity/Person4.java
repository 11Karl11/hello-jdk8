package hello.genericity;

import lombok.Data;

/**
 * @author karl xie
 */
@Data
public class Person4<T> {

    private T name;

    public void show() {
        System.out.println("方法被调用");
    }


    public void show1(Person4<T> p) {
        this.setName(p.getName());
    }

    public void show2(Person4<?> p) {
        this.setName((T) p.getName());
    }

    //? extends T 代表的是泛型可以传入T和T的子类的类型
    public void show3(Person4<? extends T> p) {
        this.setName(p.getName());
    }

    //? super T  代表的是泛型可以传入T和T的父类的类型
    public void show4(Person4<? super T> p) {
        this.setName((T) p.getName());
    }
}