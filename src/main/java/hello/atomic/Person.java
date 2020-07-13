package hello.atomic;

/**
 * @author karl xie
 * Created on 2020-07-13 17:35
 */
public class Person {

    public volatile int id;

    public volatile int age;

    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}