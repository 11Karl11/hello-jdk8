import spock.lang.Specification



class FileRestTest extends Specification {
    // 这是一个简单的单元测试方法
    // 这里方法定义方式称为契约，可以直接用中文
    def "单元测试方法"() {
        expect:
        Math.max(1, 2) == 2
    }

    // 数据表：
    def "测试最大数1"() {
        expect:
        Math.max(a,b) == result

        // 这样一个单元测试会验证两组数据
        // 第一组 a = 1 , b = 2, result = 2
        // 第二组 a = 3 , b = 0, result = 3
        where:
        a	|b	|result
        1	|2	|2
        3	|0	|3
    }

// 数据列表
    def "测试最大数2"() {
        expect:
        Math.max(a,b) == result

        // 这样一个单元测试会验证两组数据
        // 第一组 a = 1 , b = 2, result = 2
        // 第二组 a = 3 , b = 0, result = 3
        where:
        a << [1,3]
        b << [2,0]
        result << [2,3]
    }

}

