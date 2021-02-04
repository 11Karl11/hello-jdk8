package hello.advance.pattern.diversification.processor.chain;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultProcessChain implements ProcessChain {

  private EntryImpl tail;

  private EntryImpl head;

  /**
   * create a default process chain which only contains the head and tail entry the processor of
   * head and tail entry just do nothing with the message.
   *
   */
  public DefaultProcessChain() {
    head = new EntryImpl(null, null, new HeadProcessor());
    tail = new EntryImpl(head, null, new TailProcessor());
    head.nextEntry = tail;
  }

  @Override
  public void fireProcess(Object message) {
    callNextProcess(head, message);
  }

  private void callNextProcess(Entry entry, Object message) {
    try {
      Processor processor = entry.getProcessor();
      Processor.NextProcessor nextProcessor = entry.getNextProcessor();
      processor.process(nextProcessor, message);
    } catch (Exception e) {
      fireExceptionCaught(e);
    }
  }

  @Override
  public void exceptionCaught(Throwable cause) {}

  @Override
  public void fireExceptionCaught(Throwable cause) {
    callNextExceptionCaught(head, cause);
  }

  @Override
  public ProcessChain addLast(Processor processor) {
    register(tail.preEntry, processor);
    return this;
  }

  @Override
  public ProcessChain addFirst(Processor processor) {
    register(head, processor);
    return this;
  }

  private void register(EntryImpl preEntry, Processor processor) {
    EntryImpl newEntry = new EntryImpl(preEntry, preEntry.nextEntry, processor);
    preEntry.nextEntry.preEntry = newEntry;
    preEntry.nextEntry = newEntry;
  }

  private void callNextExceptionCaught(Entry entry, Throwable cause) {
    try {
      Processor processor = entry.getProcessor();
      Processor.NextProcessor nextProcessor = entry.getNextProcessor();
      processor.exceptionCaught(nextProcessor, cause);
    } catch (Exception e) {
      // todo
      log.error("........", e);
    }
  }

  class EntryImpl implements Entry {

    private EntryImpl preEntry;

    private EntryImpl nextEntry;

    private Processor processor;

    private Processor.NextProcessor nextProcessor;

    private EntryImpl(EntryImpl prevEntry, EntryImpl nextEntry, Processor processor) {
      if (processor == null) {
        throw new IllegalArgumentException("processor");
      }
      this.nextEntry = nextEntry;
      this.preEntry = prevEntry;
      this.processor = processor;
      this.nextProcessor =
          new Processor.NextProcessor() {
            @Override
            public void exceptionCaught(Throwable e) {
              Entry nextEntry = EntryImpl.this.nextEntry;
              callNextExceptionCaught(nextEntry, e);
            }

            @Override
            public void process(Object message) {
              Entry nextEntry = EntryImpl.this.nextEntry;
              callNextProcess(nextEntry, message);
            }
          };
    }

    @Override
    public Entry getNext() {
      return nextEntry;
    }

    @Override
    public Processor getProcessor() {
      return processor;
    }

    @Override
    public Processor.NextProcessor getNextProcessor() {
      return nextProcessor;
    }

    @Override
    public void addLast() {}

    @Override
    public void remove() {}
  }

  private static class HeadProcessor extends ProcessorAdapter {}

  private static class TailProcessor extends ProcessorAdapter {

    @Override
    public void exceptionCaught(NextProcessor nextProcessor, Throwable e) {
      Throwables.propagate(e);
    }

    @Override
    public void process(NextProcessor nextProcessor, Object message) {}
  }
}
