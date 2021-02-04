package hello.advance.pattern.diversification.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NodeData implements Serializable {

  private Long id;// 节点编号
  private String item;// 监测项
  private Double data;// 监测项数据
  private Date time;// 监测项的时间
  private String tenant;

}
