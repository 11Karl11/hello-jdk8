package hello.advance.example.fifth;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author karl xie
 */
@Service
public class PayHandlerChain2 implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    Map<String, PayHandler> beansOfTypeMap;


    Map<String, Node> nodeMap = new HashMap<>();


    public void handlePay(String method, String code, List<String> beanName) {
        Node node = nodeMap.get(method);
        if (null != node) {
            node.pay(code);
        } else {
            Node newNode = null;
            for (int i = 0; i < beanName.size(); i++) {
                if (0 == i) {
                    newNode = new Node(beansOfTypeMap.get(beanName.get(i)));
                }
                if (i != beanName.size() && 0 != i) {
                    newNode.append(new Node(beansOfTypeMap.get(beanName.get(i))));
                }
            }
            newNode.pay(code);
            nodeMap.put(method, newNode);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        beansOfTypeMap = applicationContext.getBeansOfType(PayHandler.class);
    }


}
