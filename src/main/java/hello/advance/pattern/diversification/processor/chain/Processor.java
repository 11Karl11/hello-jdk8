package hello.advance.pattern.diversification.processor.chain;

/**
 * the processor means process a message.
 *
 */
public interface Processor<T> {

  void process(NextProcessor nextProcessor, T message);

  void exceptionCaught(NextProcessor nextProcessor, Throwable e) throws Exception;

  interface NextProcessor<T> {
    void exceptionCaught(Throwable e);

    void process(T message);
  }
}
