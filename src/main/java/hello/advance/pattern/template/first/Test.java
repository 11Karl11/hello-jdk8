package hello.advance.pattern.template.first;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 * Created on 2020-12-21 17:01
 */
public class Test {

    /***
     * 总结
     *    模板方法模式的核心即：
     *    在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变算法结构的情况下，重定义该算法中的某些特定步骤
     *
     */
    public static void main(String[] args){
        BaoCai baoCai = new BaoCai();
        baoCai.cookProcess();

        CodeUtils.spilt();

        SuanRong suanRong = new SuanRong();
        suanRong.cookProcess();
    }
}