package hello.advance.pattern.diversification;

import java.math.BigDecimal;

public abstract class DoubleMathUtils {

  /**
   * 对原数据进行保留指定位数小数操作.
   *
   * @param data 数据
   * @param decimals 保留小数点
   */
  public static double keepDecimalData(double data, int decimals) {
    if (decimals >= 0) {
      Float d =
          (float) (Math.round(data * ((int) Math.pow(10, decimals))))
              / ((int) Math.pow(10, decimals));
      BigDecimal bd = new BigDecimal(d + "");
      return bd.setScale(decimals, BigDecimal.ROUND_HALF_UP).doubleValue();
    } else {
      return data;
    }
  }

  /** 把单位为秒的角度转换成单位为度 */
  public static Double getAngle(double value) {
    if (Math.abs(value / 3600d) < 20d) {
      return value / 3600d;
    } else {
      return null;
    }
  }
}
