package hello.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * @author karl xie
 */
public class Test2 {

    public static void main(String[] args) throws NoSuchMethodException {
        // the ExpressionFactory implementation is de.odysseus.el.ExpressionFactoryImpl
        ExpressionFactory factory = new ExpressionFactoryImpl();

        // package de.odysseus.el.util provides a ready-to-use subclass of ELContext
        SimpleContext context = new SimpleContext();

        // map function math:max(int, int) to java.lang.Math.max(int, int) or java.lang.Math.addExact(int, int)...
        context.setFunction("math", "addExact", Math.class.getMethod("addExact", int.class, int.class));

        // map variable foo to 0
        context.setVariable("foo", factory.createValueExpression(111, int.class));

        //context.setVariable("bar", factory.createValueExpression(11, int.class));
        // parse our expression
        ValueExpression e = factory.createValueExpression(context, "${math:addExact(foo,bar)}", int.class);

        // set value for top-level property "bar" to 1
        factory.createValueExpression(context, "${bar}", int.class).setValue(context, 11);


        // get value for our expression
        System.out.println(e.getValue(context)); // --> 1

    }
}