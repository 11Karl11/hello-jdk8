package hello.advance.pattern.template.second;

/**
 * 动态指定实现类的最好方式无非这么几种，大家可以根据需求选择：
 *
 * 配置文件 + 反射构建实现类
 * 配置文件 + 预先加载所有实现类，根据配置动态选择
 * 数据库配置 + 反射（可以使用CGLIB代理）
 * 数据库配置 + 预先加载所有实现类，根据配置动态选择
 * @author karl xie
 * Created on 2020-12-21 17:25
 */
public class Test {
    public static void main(String[] args) {
        // 可以使用方便的方式构建实现类, 比如我们公司使用的是数据库配置 + CGLIB（代理）
        SSOContextAnalysis sso = new LongTuSSOHandle();

        // Do AnyThings...
    }
}