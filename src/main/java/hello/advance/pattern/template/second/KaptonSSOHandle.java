package hello.advance.pattern.template.second;

/**
 * @author karl xie
 * Created on 2020-12-21 17:24
 */
public class KaptonSSOHandle implements SSOContextAnalysis{

    @Override
    public void toLogin(SSOConfig ssoConfig) {

    }

    @Override
    public Object getToken(SSOConfig ssoConfig) {
        return null;
    }

    @Override
    public String getUserInfo(SSOConfig ssoConfig, Object arg) {
        return null;
    }

    @Override
    public String getAccount(SSOConfig ssoConfig, Object userInfo) {
        return null;
    }

    @Override
    public boolean tologout(SSOConfig ssoConfig) {
        return false;
    }
}