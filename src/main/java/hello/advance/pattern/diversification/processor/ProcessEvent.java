package hello.advance.pattern.diversification.processor;


import hello.advance.pattern.diversification.processor.chain.Processor;

public class ProcessEvent implements Runnable {

  private Processor.NextProcessor nextProcessor;

  private Object message;

  private String tenant;

  public ProcessEvent(Processor.NextProcessor nextProcessor, Object message) {
    this.nextProcessor = nextProcessor;
    this.message = message;
    this.tenant = "paas";
    afterInit();
  }

  public ProcessEvent(Processor.NextProcessor nextProcessor, Object message, String tenant) {
    this.nextProcessor = nextProcessor;
    this.message = message;
    this.tenant = tenant;
    afterInit();
  }

  public void afterInit() {
    if (this.tenant == null) {
      throw new IllegalStateException(
          "the tenant key is empty, make sure you have assign "
              + "the tenant key before processing the message");
    }
  }

  @Override
  public void run() {
    fire();
  }

  /** the event will be fired */
  public void fire() {
    try {
      nextProcessor.process(message);
    } catch (Throwable e) {
      nextProcessor.exceptionCaught(e);
    }
  }
}
