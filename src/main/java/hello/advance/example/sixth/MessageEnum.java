package hello.advance.example.sixth;

import java.util.Arrays;

/**
 * @author karl xie
 */
public enum MessageEnum {
    SUCCESS(1, "成功"),
    FAIL(-1, "失败"),
    TIME_OUT(-2, "网络超时"),
    PARAM_ERROR(-3, "参数错误");

    private int code;
    private String message;

    MessageEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static String getMessage(int code) {
        MessageEnum messageEnum = MessageEnum.getMessageEnum(code);
        return messageEnum.getMessage();
    }


    public static MessageEnum getMessageEnum(int code) {
        return Arrays.stream(MessageEnum.values()).filter(x -> x.code == code).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(getMessage(1));
    }
}

