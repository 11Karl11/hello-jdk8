package hello.advance.pattern.diversification.basic;


import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.CollectionProcessorAdapter;

import java.util.List;

public class TenantTagProcessor extends CollectionProcessorAdapter<List<NodeData>> {

  @Override
  protected List<NodeData> doProcess(List<NodeData> collection) {
    System.out.println("1");
    return collection;
  }
}
