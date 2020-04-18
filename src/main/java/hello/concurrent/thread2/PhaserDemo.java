package hello.concurrent.thread2;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * 这⾥要注意关卡1的输出，在“加载新⼿教程”线程中调⽤ 了 arriveAndDeregister() 减少⼀个party之后，
 * 后⾯的线程使 ⽤ getRegisteredParties() 得到的是已经被修改后的parties了。但是当前这个阶段
 * (phase)，仍然是需要4个parties都arrive才触发屏障的。从下⼀个阶段开始，才需 要3个parties都arrive就触发屏障。
 * 另外Phaser类⽤来控制某个阶段的线程数量很有⽤，但它并在意这个阶段具体有哪 些线程arrive，只要达到它当前阶段的parties值，就触发屏障。
 * 所以我这⾥的案例 虽然制定了特定的线程（加载新⼿教程）来更直观地表述Phaser的功能，但是其实
 * Phaser是没有分辨具体是哪个线程的功能的，它在意的只是数量，这⼀点需要读者 注意
 *
 * @author karl xie
 * Created on 2020-04-18 17:01
 */
@Slf4j
public class PhaserDemo {

    static class PreTaskThread implements Runnable {
        private String task;
        private Phaser phaser;

        public PreTaskThread(String task, Phaser phaser) {
            this.task = task;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for (int i = 1; i < 4; i++) {
                try {
                    // 第⼆次关卡起不加载NPC，跳过
                    if (i >= 2 && "加载新⼿教程".equals(task)) {
                        continue;
                    }
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    log.info("关卡{}，需要加载{}个模块，当前模块{}",i,phaser.getRegisteredParties(),task);
                    // 从第⼆个关卡起，不加载NPC
                    if (i == 1 && "加载新⼿教程".equals(task)) {
                        System.out.println("下次关卡移除加载【新⼿教程】模块");
                        phaser.arriveAndDeregister(); // 移除⼀个模块
                    } else {
                        //阻塞到任务都完成,才会开始下一个阶段
                        phaser.arriveAndAwaitAdvance();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser(4) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println(String.format("第%d次关卡准备完成", phase + 1));
                return phase == 3 || registeredParties == 0;
            }
        };
        new Thread(new PreTaskThread("加载地图数据", phaser)).start();
        new Thread(new PreTaskThread("加载⼈物模型", phaser)).start();
        new Thread(new PreTaskThread("加载背景⾳乐", phaser)).start();
        new Thread(new PreTaskThread("加载新⼿教程", phaser)).start();
    }
}
