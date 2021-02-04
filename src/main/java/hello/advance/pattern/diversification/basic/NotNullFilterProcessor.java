package hello.advance.pattern.diversification.basic;


import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.basic.FilterProcessorAdapter;

public class NotNullFilterProcessor extends FilterProcessorAdapter<NodeData> {
  @Override
  public boolean filter(NodeData object) {
    return object == null || object.getData() == null;
  }
}
