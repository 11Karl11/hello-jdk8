package hello.advance.pattern.composite.first;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        Menu meat = new Menu("炒菜类");

        MenuItem item1 = new MenuItem("宫保鸡丁");
        MenuItem item2 = new MenuItem("剁椒鸡蛋");
        MenuItem item3 = new MenuItem("鱼香肉丝");

        Menu vegetable = new Menu("素食");
        MenuItem v1 = new MenuItem("酸辣土豆丝");
        MenuItem v2 = new MenuItem("爆炒包菜");

        meat.add(item1);
        meat.add(item2);
        meat.add(item3);

        vegetable.add(v1);
        vegetable.add(v2);

        meat.add(vegetable);

        meat.print();
    }
}