package hello.demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karl xie
 * Created on 2020-04-21 11:13
 */
public class GenericsDemo {
    public static void main(String[] args) {
        List<Object> objectList = Lists.newArrayList();
        List<String> stringList = Lists.newArrayList();
        objectList.addAll(stringList);
    }

    public void inspect(List<Object> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
        list.add(1); //这个操作在当前方法的上下文是合法的。
    }

    public void test() {
        List<String> strs = new ArrayList<String>();
       // inspect(strs); //编译错误
    }

}