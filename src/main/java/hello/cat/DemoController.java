package hello.cat;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author karl xie
 */
@Slf4j
@RestController
@RequestMapping(("/demo"))
public class DemoController {

    @GetMapping("/transaction")
    public String transaction() {
        // <1> 创建 Transaction 对象
        Transaction t = Cat.newTransaction("URL", "/demo/transaction");
        try {
            // <2> ... yourBusiness(); 业务逻辑

            // <3> 设置 Transaction 的状态为成功
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // <4> 设置 Transaction 的状态为异常
            t.setStatus(e);
        } finally {
            // <5> 标记 Transaction 结束
            t.complete();
        }
        return "success";

    }


    @GetMapping("/event-01")
    public String event01() {
        // Cat.logEvent("URL.Server", "127.0.0.1");
        Cat.logEvent("URL.Server", "127.0.0.1", Event.SUCCESS, "data");
        return "success";
    }


    @GetMapping("/event-02")
    public String event02() {
        try {
            int result = 1 / 0;
        } catch (Throwable e) {
            Cat.logError(e);
            // Cat.logError("custom-message", e);
        }
        return "success";
    }



    @GetMapping("/event-03")
    public String event03() {
        try {
            int result = 1 / 0;
        } catch (Throwable e) {
            Cat.logErrorWithCategory("custom-category", e);
            // Cat.logErrorWithCategory("custom-category", "custom-message", e);
        }
        return "success";
    }



    @GetMapping("/metric-01")
    public String metric01() {
        Cat.logMetricForCount("visit.count", 1);
        return "success";
    }


    @GetMapping("/metric-02")
    public String metric02() {
        Cat.logMetricForDuration("visit.duration", 10L);
        return "success";
    }

    @GetMapping("/hello/de")
    public String hello() {
        // try {
        //     int a = 1/0;
        // }catch (Exception e){
        //     log.error("----error",e);
        // }
        return "world";
    }


}