package hello.demo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 控制台报错：java.util.ConcurrentModificationException。
 * 这是怎么回事，然后去看了看这个异常，才发现自己果然还是太年轻啊。
 * 我们都知道增加for循环即foreach循环其实就是根据list对象创建一个iterator迭代对象，用这个迭代对象来遍历list，相当于list对象中元素的遍历托管给了iterator，如果要对list进行增删操作，都必须经过iterator。
 * 每次foreach循环时都有以下两个操作
 *
 * iterator.hasNext(); //判读是否有下个元素
 * item = iterator.next(); //下个元素是什么，并把它赋给item。
 *
 * 可以看到是进入checkForComodification()方法的时候报错了，也就是说modCount != expectedModCount。
 * 具体的原因是：以foreach方式遍历元素的时候，会生成iterator，然后使用iterator遍历。在生成iterator的时候，
 * 会保存一个expectedModCount参数，这个是生成iterator的时候期望List中修改元素的次数。如果你在遍历过程中删除元素，List中modCount就会变化
 *
 * 那么就要求hasNext()的方法返回false了，即cursor == size。其中cursor是Itr类（Iterator子类）中的一个字段，
 * 用来保存当前iterator的位置信息，从0开始。cursor本身就是游标的意思，在数据库的操作中用的比较多。只要curosr不等于size就认为存在元素。
 * 由于Itr是ArrayList的内部类，因此直接调用了ArrayList的size字段，所以这个字段的值是动态变化的，既然是动态变化的可能就会有问题出现了。
 * 我们以上面的代码为例，当到倒数第二个数据也就是“1”的时候，cursor是1，然后调用删除操作，此时size由2变成了1，当再调用hasNext判断的时候，
 * cursor==size，就会调用后面的操作直接退出循环了。
 * @author karl xie
 * Created on 2020-04-21 16:27
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        // StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("1");
        // stringBuilder.append(222);
        // System.out.println(stringBuilder.toString());

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);


    }
}