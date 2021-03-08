package hello.jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author karl xie
 */
public class TestTX {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.136.130", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k1",1);
        jsonObject.put("k3",3);
        //开启事务
        Transaction multi = jedis.multi();

        try {
            multi.set("user1",jsonObject.toJSONString());
            multi.set("user2",jsonObject.toJSONString());
            int i =1/0;//模拟失败
            //执行事务
            multi.exec();
        } catch (Exception e) {
            //放弃事务
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
        }


    }
}