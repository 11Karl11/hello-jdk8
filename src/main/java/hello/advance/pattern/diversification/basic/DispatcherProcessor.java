package hello.advance.pattern.diversification.basic;


import hello.advance.pattern.diversification.CollectionUtils;
import hello.advance.pattern.diversification.processor.basic.ExecutorProcessor;

import java.util.Collection;

/** 这个分发process 可以进行异步或者异步， 如果为异步 */
public class DispatcherProcessor extends ExecutorProcessor {

  private final boolean asyncEnabled;

  public DispatcherProcessor() {
    this.asyncEnabled = false;
  }

  /** @param asyncEnabled 是否支持异步操作 */
  public DispatcherProcessor(boolean asyncEnabled) {
    this.asyncEnabled = asyncEnabled;
  }

  /** todo 目前这个一个接一个处理， 并没有做到并行处理， 并且没有做到一个处理异常不会影响下一个处理 */
  @Override
  public void process(NextProcessor nextProcessor, Object message) {
    System.out.println("4");
    if (!(message instanceof Collection)) {
      throw new IllegalArgumentException("the type of message requires [collection].");
    }
    Collection collection = (Collection) message;
    if (CollectionUtils.isEmpty(collection)) {
      return;
    }
    for (Object c : collection) {
      if (!asyncEnabled) {
        try {
          nextProcessor.process(c);
        } catch (Exception e) {
          nextProcessor.exceptionCaught(e);
        }
      } else {
        super.process(nextProcessor, c);
      }
    }
  }

  @Override
  public void exceptionCaught(NextProcessor nextProcessor, Throwable e) {
    nextProcessor.exceptionCaught(e);
  }
}
