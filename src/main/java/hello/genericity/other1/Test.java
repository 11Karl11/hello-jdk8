package hello.genericity.other1;

import hello.genericity.other.Plate;

/**
 * Effective Java这本书里面介绍的PECS原则。
 * 上界<? extends T>不能往里存，只能往外取，适合频繁往外面读取内容的场景。
 *
 * 上边界符 ? extends 只是限定了赋值给它的实例类型，且边界包括自身。
 * 上边界符 ? extends 跟 ？ 一样能取不能存，道理是一样的，虽然限定了上边界，但编译器依然不知道 ? 是啥类型，故不能存；但是限定了上边界，故取出来的对象类型默认为上边界的类型
 *
 *
 * 下界<? super T>不影响往里存，但往外取只能放在Object对象里，适合经常往里面插入数据的场景。
 *
 * 下边界符 ？super，跟上边界符一样，只是限定了赋值给它的实例类型，也包括边界自身
 * 下边界符 ？super 能存能取，因为设定了下边界，故我们能存下边界以下的类型，当然也包括边界自身；然而取得时候编译器依然不知道 ? 具体是什么类型，故取出默认为Object类型。
 *
 *
 *
 *
 * 首先 List<? extents Fruit> fList= xxx 可以是 fList = List<Apple> 也可以是 fList = List<Banana> ，
 * 编译时刻 是没法确定 这个变量最终会指向谁，没准运行的时刻 你的指向一直在变呢 对吧？假如你指向了 Apple 那往苹果的盘子里添加香蕉总是不对的吧？
 * 香蕉是没法转型成苹果的，当然object也是不能向下转型成苹果的, 所以索性禁止你添加任何元素 除了null，
 *
 *
 *
 * 往下是深不见底的 鬼知道你的盘子最终会要装啥 红苹果 红色烂苹果 红色富士苹果 看不透啊
 *
 *
 *
 * 接着看 List<? super Apple > aList = xxx 可以是 aList = List<Apple> 也可以是 aList = List<Fruit> 还可以是 aList = List<Food> ，
 * 那么我们可以往苹果的盘子里放红苹果么 当然是没问题的 红苹果可以安全的向上转型成苹果，极端情况 你的盘子指向了Object ，
 * 把一个红苹果转成Object也是没任何问题的，那么我们可以向这个集合中添加 Food 么 ？不行的 因为你的盘子 可能指向 水果 aList = List<Fruit> Food是没法安全的转型成 水果的 ，
 * 同理Object也是不能添加的
 *
 *
 *
 * 总结一下 就是说 List<? xxx A> list 声明了 list这个变量 可以指向哪种类型的集合，但不是一种确定的类型 而是一个范围 ，
 * 只要我们的右值在这个范围内 就可以赋值给这个变量，而又因为 只声明了一个范围 ，所以具体是啥类型在编译时刻没法确定
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        Plate<? extends Food> p = new Plate<>(new Apple());
        // p.setItems(new Fruit());
        // p.setItems(new Apple());
        Food items = p.getItems();
        System.out.println(items.getClass());

        System.out.println("----------------------------");

        Plate<? super Fruit> p1 =new Plate<>();

        p1.setItems(new Fruit());
        p1.setItems(new Apple());


    }
}