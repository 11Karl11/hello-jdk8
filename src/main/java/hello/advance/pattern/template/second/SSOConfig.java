package hello.advance.pattern.template.second;

import lombok.Data;

/**
 * @author karl xie
 */
@Data
public class SSOConfig {

    private String implClassName;

    private String loginUrl;

    private String userUrl;

    private String logoutUrl;

    private String callBackUrl;
}