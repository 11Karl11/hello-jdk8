package hello.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * Juel是Java Unified Expression Language的简称，即Java统一表达语言，在JSP2.1标准(JSR-245)中定义的一部分。
 * 尽管EL表达式是伴随着JSP而生，但现在已经可以在非JSP应用中使用，相关的API放在javax.el包里面。
 *
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) {
        //step1
        ExpressionFactory factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();

        //step2
        context.setVariable("var1", factory.createValueExpression("Hello", String.class));
        context.setVariable("var2", factory.createValueExpression("World", String.class));

        //step3
        String s = "{\"argIn1\":\"${var1}\",\"argIn2\":\"${var2}\"}";
        ValueExpression e = factory.createValueExpression(context, s, String.class);
        System.out.println(e.getValue(context));// --> {"argIn1":"Hello","argIn2":"World"}
    }
}