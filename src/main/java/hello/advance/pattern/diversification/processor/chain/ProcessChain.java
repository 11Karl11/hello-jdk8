package hello.advance.pattern.diversification.processor.chain;

public interface ProcessChain {
  /**
   * firing the process chain to process the message.
   *
   * @param message the message firing the processor to be process
   */
  void fireProcess(Object message);

  /** catch up the exception and process the exception. */
  void exceptionCaught(Throwable cause);

  void fireExceptionCaught(Throwable cause);

  /** add the processor to the last of the filter chain. */
  ProcessChain addLast(Processor processor);

  ProcessChain addFirst(Processor processor);

  /** represent a process entry, which wraps a process and link to nextProcessor. */
  interface Entry {
    Entry getNext();

    Processor getProcessor();

    Processor.NextProcessor getNextProcessor();

    void addLast();

    void remove();
  }
}
