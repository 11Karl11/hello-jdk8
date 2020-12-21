package hello.advance.pattern.template.second;

import lombok.Data;

/**
 * @author karl xie
 * Created on 2020-12-21 17:23
 */
@Data
public class SSOConfig {

    private String implClassName;

    private String loginUrl;

    private String userUrl;

    private String logoutUrl;

    private String callBackUrl;
}