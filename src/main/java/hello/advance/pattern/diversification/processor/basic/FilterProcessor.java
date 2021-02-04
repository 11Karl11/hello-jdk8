package hello.advance.pattern.diversification.processor.basic;


import hello.advance.pattern.diversification.processor.IFilter;
import hello.advance.pattern.diversification.processor.chain.Processor;

public abstract class FilterProcessor<T> implements IFilter<T>, Processor<T> {

  @Override
  public void process(Processor.NextProcessor nextProcessor, T message) {
    if (!filter(message)) {
      doProcess(nextProcessor, message);
    }
  }

  protected abstract void doProcess(NextProcessor nextProcessor, T message);
}
