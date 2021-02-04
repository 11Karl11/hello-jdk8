package hello.advance.pattern.diversification.processor.chain;


import hello.advance.pattern.diversification.CollectionUtils;

import java.util.Collection;

/**
 * 一次性处理整个集合
 *
 * @param <T>
 */
public abstract class CollectionProcessorAdapter<T extends Collection<?>> implements Processor<T> {

  @Override
  public void process(NextProcessor nextProcessor, T collection) {
    if (CollectionUtils.isEmpty(collection)) {
      return;
    } else {
      T retVal = doProcess(collection);
      nextProcessor.process(retVal);
    }
  }

  protected abstract T doProcess(T collection);

  @Override
  public void exceptionCaught(NextProcessor nextProcessor, Throwable e) throws Exception {
    nextProcessor.exceptionCaught(e);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
