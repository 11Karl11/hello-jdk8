package hello.material.pattern.factory.simple;

import hello.material.pattern.factory.bean.House;

/**
 * 简单工厂将对象的创建过程进行了封装，用户不需要知道具体的创建过程，只需要简单的通过调用工厂类获取相应的对象即可。
 * 当我们要新增一类产品的时候我们需要新增对应的产品类，这点满足了开闭原则中的对应扩展开放。
 * 但是我们还得修改工厂类，在switch语句中再加判断，这点不满足开闭原则中的对修改关闭。
 * 另外对于简单工厂来说只适用于简单对象创建，对于复杂的产品创建会造成工厂类逻辑过于复杂。
 * 而且简单工厂模式通常使用静态工厂方法，这使得无法由子类继承，造成工厂角色无法形成基于继承的等级结构。
 *
 * @author karl xie
 */
public class Client {

    public static void main(String[] args) {
        House house = SimpleFactory.getHouse("1");
        house.show();
        house.showParlor();
    }
}