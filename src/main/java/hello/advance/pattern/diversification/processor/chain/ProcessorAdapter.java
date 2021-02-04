package hello.advance.pattern.diversification.processor.chain;

public class ProcessorAdapter<T> implements Processor<T> {

  @Override
  public void process(NextProcessor nextProcessor, T message) {
    if (message == null) {
      return;
    }
    Object retVal = doProcess(message);
    nextProcessor.process(retVal);
  }

  protected Object doProcess(T message) {
    return message;
  }

  @Override
  public void exceptionCaught(NextProcessor nextProcessor, Throwable e) throws Exception {
    nextProcessor.exceptionCaught(e);
  }
}
