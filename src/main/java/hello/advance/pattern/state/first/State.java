package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public interface State {

    /** 投币 **/
    default void giveMoney() {
        System.out.println("无法投币");
    }

    /** 移动滑杆 **/
    default void move() {
        System.out.println("无法移动滑杆");
    }

    /** 抓取 **/
    default void grab() {
        System.out.println("无法抓取");
    }

    void changeState();
}
