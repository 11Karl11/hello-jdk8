package hello.advance.pattern.diversification.basic;


import hello.advance.pattern.diversification.DoubleMathUtils;
import hello.advance.pattern.diversification.pojo.NodeData;

public class DecimalProcessor extends NotNullFilterProcessor {
  private final int decimal;

  private static final int DEFAULT_DECIMAL = 4;

  public DecimalProcessor() {
    decimal = DEFAULT_DECIMAL;
  }

  public DecimalProcessor(int decimal) {
    this.decimal = decimal;
  }

  @Override
  protected void doProcess(NextProcessor nextProcessor, NodeData data) {
    System.out.println(7);
    data.setData(DoubleMathUtils.keepDecimalData(data.getData(), decimal));
    nextProcessor.process(data);
  }
}
