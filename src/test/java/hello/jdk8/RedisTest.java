package hello.jdk8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.jedis.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @author karl xie
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Test
    void test1() {

        ListOperations listOperations = redisTemplate.opsForList();

        listOperations.leftPush("list", 1);

        System.out.println(listOperations.leftPop("list"));


        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        String ping = connection.ping();


        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset", "karl", 111);
        zSetOperations.add("zset", "name", 22);
        zSetOperations.add("zset", "url", 11331);

        System.out.println(zSetOperations.range("zset", 0, -1));
        System.out.println(zSetOperations.rangeByScore("zset", Double.MIN_VALUE, Double.MAX_VALUE));
        System.out.println(zSetOperations.rangeByScoreWithScores("zset", Double.MIN_VALUE, Double.MAX_VALUE));
        Set zset = zSetOperations.rangeByScoreWithScores("zset", Double.MIN_VALUE, Double.MAX_VALUE);


    }

    @Test
    void test2() throws JsonProcessingException {

        ValueOperations valueOperations = redisTemplate.opsForValue();

        User karl = User.builder().name("karl").age(11).build();

        String json = new ObjectMapper().writeValueAsString(karl);

        valueOperations.set("user", json);

        System.out.println(valueOperations.get("user"));
    }

    @Test
    void test3() {
        InMemoryStoreAdapter inMemoryStoreAdapter = new InMemoryStoreAdapter(redisConnectionFactory);
        ValueOperations valueOperations = inMemoryStoreAdapter.redisTemplate.opsForValue();
        byte[] bytes = "kk".getBytes();
        valueOperations.set("karl", bytes);

        byte[] karl = (byte[]) valueOperations.get("karl");


        System.out.println(new String(karl));
    }


}