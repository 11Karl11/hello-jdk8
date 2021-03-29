package hello.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * @author karl xie
 */
public class Test4 {

    public static void main(String[] args) throws NoSuchMethodException {

        // the ExpressionFactory implementation is de.odysseus.el.ExpressionFactoryImpl
        ExpressionFactory factory = new ExpressionFactoryImpl();

        // package de.odysseus.el.util provides a ready-to-use subclass of ELContext
        SimpleContext context = new SimpleContext();

        // map function math:max(int, int) to java.lang.Math.max(int, int) or java.lang.Math.addExact(int, int)...
        context.setFunction("math", "sin", Math.class.getMethod("sin", double.class));

        // map variable foo to 0
        context.setVariable("foo", factory.createValueExpression(Math.PI/6, double.class));

        ValueExpression e = factory.createValueExpression(context, "${math:sin(foo)}", double.class);

        System.out.println(e.getValue(context));

    }
}