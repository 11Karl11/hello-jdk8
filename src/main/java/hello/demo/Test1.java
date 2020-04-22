package hello.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 如果是 boolean 基本数据类型变量（boolean 命名不需要加 is
 * 前缀），会自动调用 isXxx()方法。
 * 说明：注意如果是 Boolean 包装类对象，优先调用 getXxx()的方法。
 * @author karl xie
 * Created on 2020-04-21 17:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test1 {
    private boolean flag;

    public static void main(String[] args) {
        Test1 test1 = new Test1(true);
        boolean a = test1.isFlag();
        System.out.println(a);
    }
}