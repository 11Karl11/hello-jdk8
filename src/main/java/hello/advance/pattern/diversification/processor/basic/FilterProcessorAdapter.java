package hello.advance.pattern.diversification.processor.basic;


import hello.advance.pattern.diversification.processor.chain.Processor;

public class FilterProcessorAdapter<T> extends FilterProcessor<T> {
  @Override
  public boolean filter(T object) {
    return false;
  }

  @Override
  protected void doProcess(Processor.NextProcessor nextProcessor, T message) {
    nextProcessor.process(message);
  }

  @Override
  public void exceptionCaught(Processor.NextProcessor nextProcessor, Throwable e) {
    nextProcessor.exceptionCaught(e);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
