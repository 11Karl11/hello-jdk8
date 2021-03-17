package hello.advance.example.fifth;

import lombok.Getter;
import lombok.Setter;

/**
 * @author karl xie
 */
public abstract class PayHandler {

    protected Integer priority;

    @Getter
    @Setter
    protected PayHandler next;

    public abstract void pay(String pay);

    //为节点追回节点
    public PayHandler append(PayHandler node) {
        //当前节点
        PayHandler currentNode = this;
        //循环向后找
        while (true) {
            //取出下一个节点
            PayHandler nextNode = currentNode.next;
            //如果下一个节点为null,当前节点已经是最后一个节点
            if (nextNode == null) {
                break;
            }
            //赋给当前节点
            currentNode = nextNode;
        }
        //把需要追回的节点追加为找到的当前节点的下一个节点
        currentNode.next = node;
        return this;
    }

    public abstract boolean pay2(String code);
}