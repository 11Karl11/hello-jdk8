package hello.advance.pattern.diversification.basic;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.CollectionProcessorAdapter;

import java.util.Collection;

public class NullValueFilterProcessor<T extends Collection<NodeData>>
    extends CollectionProcessorAdapter<T> {

  @Override
  protected T doProcess(T collection) {
      System.out.println("2");
    return (T)
        FluentIterable.from(collection)
            .filter(
                new Predicate<NodeData>() {
                  @Override
                  public boolean apply(NodeData nodeData) {
                    return (nodeData != null && nodeData.getData() != null);
                  }
                })
            .toList();
  }
}
