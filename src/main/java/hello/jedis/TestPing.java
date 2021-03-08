package hello.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author karl xie
 */
public class TestPing {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.136.130", 6379);

        System.out.println(jedis.ping());
    }
}