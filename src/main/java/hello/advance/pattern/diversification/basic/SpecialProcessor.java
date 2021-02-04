package hello.advance.pattern.diversification.basic;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import hello.advance.pattern.diversification.pojo.NodeData;
import hello.advance.pattern.diversification.processor.chain.ProcessorAdapter;

public class SpecialProcessor extends ProcessorAdapter<NodeData> {

  /** sz 特殊处理 */
  static final Range IDS = Range.range(95, BoundType.CLOSED, 104, BoundType.CLOSED);

  static final Range IDS_SL = Range.range(36, BoundType.CLOSED, 38, BoundType.CLOSED);
  private static final double DATA_CONVERT_UNITS = 10.0;

  @Override
  protected NodeData doProcess(NodeData nodeData) {
    System.out.println(5);
    if ("gpsz".equals("gpsz")) {
      if (IDS.contains(nodeData.getId().intValue()) || IDS_SL.contains(nodeData.getId().intValue())) {
        nodeData.setData(nodeData.getData() / DATA_CONVERT_UNITS);
      }
    }
    return nodeData;
  }
}
