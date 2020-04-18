package hello.concurrent.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 参考CopyOnWriteArrayList实现的CopyOnWriteMap，我们可以⽤这个容 器来做什么呢？结合我们之前说的CopyOnWrite的复制思想，
 * 它最适⽤于“读多写 少”的并发场景。 场景：假如我们有⼀个搜索的⽹站需要屏蔽⼀些“关键字”，“⿊名单”每晚定时更
 * 新，每当⽤户搜索的时候，“⿊名单”中的关键字不会出现在搜索结果当中，并且提 示⽤户敏感字。
 * @author karl xie
 * Created on 2020-04-18 10:56
 */
public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {


    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap() {
        internalMap = new HashMap<K, V>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        synchronized (this) {
            HashMap<K, V> newMap = new HashMap<>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this) {
            HashMap<K, V> newMap = new HashMap<>(internalMap);
            newMap.putAll(m);
            internalMap = newMap;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}