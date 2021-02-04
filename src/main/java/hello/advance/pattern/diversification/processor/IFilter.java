package hello.advance.pattern.diversification.processor;

/**
 * Filter 接口.
 */
public interface IFilter<T> {

  /**
   * 对数据进行过滤.
   *
   * @param object 对象
   * @return true 将被过滤，false 不过滤
   */
  boolean filter(T object);
}
