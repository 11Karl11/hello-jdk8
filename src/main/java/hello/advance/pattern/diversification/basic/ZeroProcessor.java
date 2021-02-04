package hello.advance.pattern.diversification.basic;

import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.ProcessorAdapter;

public class ZeroProcessor extends ProcessorAdapter<NodeData> {

  @Override
  protected Object doProcess(NodeData message) {
    // TODO: 2021/2/3
    System.out.println(6);
    return message;
  }
}
