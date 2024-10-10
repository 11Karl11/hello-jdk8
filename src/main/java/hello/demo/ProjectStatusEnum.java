package hello.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author karl xie
 * Created on 2024-02-06 15:40
 */
@Getter// 只允许对属性 get，不允许 set
@RequiredArgsConstructor// 为枚举的每个属性生成有参构造
public enum ProjectStatusEnum {
    SURVEY("已调研"),
    APPROVAL("已立项"),
    PROGRESSING("进行中"),
    COMPLETED("已完成");
    // 对该成员变量使用 final 来修饰，表明一旦赋值就不可变
    private final String name;
}
