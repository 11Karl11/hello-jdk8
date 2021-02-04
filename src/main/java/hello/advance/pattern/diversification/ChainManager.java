package hello.advance.pattern.diversification;

import hello.advance.pattern.diversification.basic.*;
import hello.advance.pattern.diversification.processor.chain.DefaultProcessChainBuilder;
import hello.advance.pattern.diversification.processor.chain.Processor;


public class ChainManager {

  private ZeroProcessor zeroProcessor = new ZeroProcessor();

  private DispatcherProcessor dispatcherProcessor = new DispatcherProcessor(false);

  public DefaultProcessChainBuilder defaultProcessChainBuilder() {
    return build(
            new TenantTagProcessor(),
            new NullValueFilterProcessor(),
            new CalibrationProcessor(),
            dispatcherProcessor,
            new SpecialProcessor(),
            zeroProcessor,
            new DecimalProcessor());
  }

  public DefaultProcessChainBuilder build(Processor... processors) {
    return new DefaultProcessChainBuilder().addLast(processors);
  }
}
