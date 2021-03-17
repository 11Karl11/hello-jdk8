package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 */
public enum LoggerEnums {

    INFO(1, "INFO级别错误"),
    DEBUG(2, "DEBUG级别错误"),
    ERROR(3, "ERROR级别错误");

    private int value;
    private String desc;

    LoggerEnums(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}