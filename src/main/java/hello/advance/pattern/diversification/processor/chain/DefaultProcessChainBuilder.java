package hello.advance.pattern.diversification.processor.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * process chain builder helps building a process chain. example: new
 * DefaultProcessChainBuilder().addLast(....).buildProcessChain(chain);
 *
 */
public class DefaultProcessChainBuilder implements ProcessChainBuilder {

  private List<ProcessChain.Entry> entries = new ArrayList<>();

  @Override
  public ProcessChain buildProcessChain(ProcessChain chain) {
    for (ProcessChain.Entry e : entries) {
      chain.addLast(e.getProcessor());
    }
    return chain;
  }

  public synchronized DefaultProcessChainBuilder addLast(Processor... processors) {
    for (Processor processor : processors) {
      addLast(processor);
    }
    return this;
  }

  // public synchronized DefaultProcessChainBuilder addFirst(Processor processor) {
  //   register(0, new EntryImpl(processor));
  //   return this;
  // }

  // private void register(int index, ProcessChain.Entry e) {
  //   entries.add(index, e);
  // }

  public synchronized DefaultProcessChainBuilder addLast(Processor processor) {
    register(processor);
    return this;
  }

  private void register(Processor processor) {
    entries.add(new StaticEntryImpl(processor));
  }

  private static class StaticEntryImpl implements ProcessChain.Entry {
    private volatile Processor processor;

    private StaticEntryImpl(Processor processor) {
      if (processor == null) {
        throw new IllegalArgumentException("processor");
      }
      this.processor = processor;
    }

    @Override
    public ProcessChain.Entry getNext() {
      return null;
    }

    @Override
    public Processor getProcessor() {
      return processor;
    }

    @Override
    public Processor.NextProcessor getNextProcessor() {
      throw new IllegalStateException();
    }

    @Override
    public void addLast() {}

    @Override
    public void remove() {}
  }
}
