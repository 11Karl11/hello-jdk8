package hello.advance.others.anonymous;

/**
 * 操作符：new；
 * 一个要实现的接口或要继承的类，案例一中的匿名类实现了HellowWorld接口，案例二中的匿名内部类继承了Animal父类；
 * 一对括号，如果是匿名子类，与实例化普通类的语法类似，如果有构造参数，要带上构造参数；如果是实现一个接口，只需要一对空括号即可；
 * 一段被"{}"括起来类声明主体；
 * 末尾的";"号（因为匿名类的声明是一个表达式，是语句的一部分，因此要以分号结尾）。
 *
 * @author karl xie
 */
public class AnimalTest {

    private final String ANIMAL = "动物";

    public void accessTest() {
        System.out.println("匿名内部类访问其外部类方法");
    }

    class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void printAnimalName() {
            System.out.println(bird.name);
        }
    }

    // 鸟类，匿名子类，继承自Animal类，可以覆写父类方法   （匿名子类（继承父类））
    Animal bird = new Animal("布谷鸟") {

        @Override
        public void printAnimalName() {
            accessTest();   // 访问外部类成员
            System.out.println(ANIMAL);  // 访问外部类final修饰的变量
            super.printAnimalName();
        }
    };

    public void print() {
        bird.printAnimalName();
    }


    public static void main(String[] args) {

        AnimalTest animalTest = new AnimalTest();
        animalTest.print();
    }
}