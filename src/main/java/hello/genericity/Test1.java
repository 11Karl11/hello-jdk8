package hello.genericity;

/**
 * java中的泛型只存在编码编译阶段
 * 在运行期间泛型类型是会被去除掉的
 *
 * 泛型擦除（在代码运行期间，将所有的泛型全部去掉）
 *
 * 为什么？
 * 为了兼容jdk老版本的编码
 *
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) {

        Person4<String> person1 = new Person4<>();
        Person4<String> person2 = new Person4<>();
        System.out.println(person1.getClass()==person2.getClass());


        System.out.println("--------------------------");

        Person4<String> person3 = new Person4<String>();
        Person4<Integer> person4 = new Person4<Integer>();
        System.out.println(person3.getClass()==person4.getClass());



    }
}