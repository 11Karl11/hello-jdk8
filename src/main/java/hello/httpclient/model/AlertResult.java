package hello.httpclient.model;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public class AlertResult {

    /**
     * success : true
     * ret : 0
     * code : SUCCESS
     * msg : success
     * data : null
     */

    private boolean success;
    private int     ret;
    private String  code;
    private String  msg;
    private Object  data;

    public AlertResult(boolean success, int ret, String code, String msg, Object data) {
        this.success = success;
        this.ret = ret;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
