package hello.concurrent.async.future;

/**
 * @author karl xie
 */
public class RealData implements Data {
    protected final String result;
    public RealData(String para) {
        StringBuffer sb=new StringBuffer();
        sb.append("输入： ");
        sb.append(para);
        //假设这里很慢很慢，构造RealData不是一个容易的事
        result =sb.toString();
    }
    public String getResult() {
        return result;
    }
}

