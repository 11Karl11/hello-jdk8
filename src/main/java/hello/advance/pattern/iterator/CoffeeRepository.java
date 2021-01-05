package hello.advance.pattern.iterator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author karl xie
 */
public class CoffeeRepository implements MyContainer {

    List<String> names = Lists.newArrayList("蓝山咖啡", "云南咖啡", "雀巢咖啡");

    @Override
    public MyIterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements MyIterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public Object next() {
            return hasNext() ? names.get(index++) : null;
        }

        NameIterator() {
            index = 0;
        }
    }
}