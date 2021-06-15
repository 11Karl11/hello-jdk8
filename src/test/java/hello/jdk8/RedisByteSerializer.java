package hello.jdk8;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author karl xie
 */
public class RedisByteSerializer {
    private final static byte[] EMPTY_ARRAY = new byte[0];


    protected final RedisTemplate<String, byte[]> redisTemplate;

    // 所有的子类都使用同一个 KeySerializer 实例
    private final static RedisSerializer<String> keySerializer = new StringRedisSerializer();

    // 所有的子类都使用同一个 ObjectMapper 实例
    private final static ObjectMapper objectMapper = new ObjectMapper();

    // 构造器
    protected RedisByteSerializer(RedisConnectionFactory redisConnectionFactory) {
        // 这里新建一个 RedisTemplate 给自己用
        this.redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);


        // 每个子类的 redisTemplate 都有自己的 ValueSerializer ，我直接把它写成匿名类了。
        RedisSerializer valueSerializer = new RedisSerializer<byte[]>() {

            @Override
            public byte[] serialize(byte[] t) throws SerializationException {
                return t == null ? EMPTY_ARRAY : t;
            }

            @Override
            public byte[] deserialize(byte[] bytes) throws SerializationException {
                return (bytes == null || bytes.length <= 0) ? null : bytes;
            }
        };

        // 设定各个序列化器
        redisTemplate.setDefaultSerializer(valueSerializer);

        redisTemplate.setKeySerializer(keySerializer);

        // redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(new Jackson2JsonRedisSerializer<>(String.class));

        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);

        // 记得调用 afterPropertiesSet()
        redisTemplate.afterPropertiesSet();

    }
}