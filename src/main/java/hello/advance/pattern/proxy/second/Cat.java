package hello.advance.pattern.proxy.second;

import java.text.MessageFormat;

/**
 * @author karl xie
 */
public class Cat implements Animal{

    @Override
    public void eat(String food) {
        System.out.println(MessageFormat.format("eat food: {0}", food));
    }
}