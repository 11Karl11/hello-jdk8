package hello.advance.pattern.iterator;

/**
 * @author karl xie
 */
public class FoodRepository implements MyContainer {

    String[] names = {"青菜", "螃蟹", "鱼"};

    @Override
    public MyIterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements MyIterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return hasNext() ? names[index++] : null;
        }

        NameIterator() {
            index = 0;
        }
    }
}