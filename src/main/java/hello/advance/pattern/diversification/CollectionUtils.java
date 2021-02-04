package hello.advance.pattern.diversification;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类.
 *
 */
public class CollectionUtils {

  private CollectionUtils() {}

  /**
   * 判断一个集合是否为空： null或size为0.
   *
   * @return true为空，false不为空
   */
  public static boolean isEmpty(Collection<?> collection) {
    return (collection == null || collection.isEmpty());
  }

  /**
   * 判断一个Map是否为空： null或size为0.
   *
   * @return true为空，false不为空
   */
  public static boolean isEmpty(Map map) {
    return (map == null || map.isEmpty());
  }

  /**
   * 判断一个数组是否为空： null或size为0.
   *
   * @return true为空，false不为空
   */
  public static <T> boolean isEmpty(T[] array) {
    return !(array != null && array.length != 0);
  }

  /**
   * 取列表中第一个元素.
   *
   * @return null if list is empty: null or []
   */
  public static <T> T first(Collection<T> collection) {
    return collection.iterator().next();
  }

  /**
   * 取列表中最后一个元素.
   *
   * @return null if list is empty: null or []
   */
  public static <T> Optional<T> last(List<T> list) {
    if (isEmpty(list)) {
      return Optional.absent();
    }
    return Optional.of(list.get(list.size() - 1));
  }

  /**
   * 将列表转为数组.
   *
   * @param value int 列表
   * @return 数组
   */
  public static Integer[] toArray(List<Integer> value) {
    Integer[] array = new Integer[value.size()];
    return value.toArray(array);
  }

  /**
   * get the size of collection.
   *
   * @param collection collection
   * @return the size of collection.
   */
  public static Integer size(Collection<?> collection) {
    if (isEmpty(collection)) {
      return 0;
    } else {
      return collection.size();
    }
  }
}
