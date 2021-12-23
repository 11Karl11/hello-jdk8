package hello.redssion;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author karl xie
 * Created on 2021-12-23 19:46
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
            Config config = new Config();
            // 使用cluster集群服务
            config.useSingleServer()
                    // 设置节点地址
                    .setAddress("redis://127.0.0.1:6379")
                    // 设置客户端连接的名字
                    .setClientName("myCluster")
                    // 设置连接密码
                    .setPassword("redis666")
                    // 使用0号数据库
                    .setDatabase(0);
            // 使用提供的配置创建Redisson客户端
        RedissonClient client = Redisson.create(config);
        // 根据名称获取一个非公平锁的实例
            RLock rLock = client.getLock("redlock");
            ExecutorService service = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 5; ++i) {
                service.submit(() -> {
                    boolean isLock;
                    try {
                        // 参数1 waitTime：向Redis获取锁的超时时间
                        // 参数2 leaseTime：锁的失效时间(从开始获取锁时计时)
                        // 参数3 unit：时间单位
                        isLock = rLock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
                        if (isLock) {
                            log.info("我获取到锁啦");
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        // 最终释放锁
                        rLock.unlock();
                    }
                });
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}