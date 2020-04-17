package hello.httpclient.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author karl xie
 * Created on 2020-04-15 14:38
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationTreeVo implements Serializable {

    private Integer id;

    private String name;

    private Integer value;

    private String monitorType;

    private Integer type;

    private Boolean selected;

}