package ecommerce.webflux.service.app.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.redisson.Redisson;
import org.redisson.RedissonBatch;
import org.redisson.RedissonReactive;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.reactive.RedissonBatchReactive;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

  /*@Bean
  public RedisCacheConfiguration cacheConfiguration() {
    return RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(60))
        .disableCachingNullValues()
        .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
    return builder -> builder
        .withCacheConfiguration("rate",
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
  }*/


  @Bean
  public CacheManager cacheManager(RedissonReactiveClient redissonClient) {
    Map<String, CacheConfig> config = new HashMap<>();
    config.put("rate", new CacheConfig());
    return new RedissonSpringCacheManager(redissonClient);
  }

  @Bean(destroyMethod = "shutdown")
  public RedissonReactiveClient redisson() {

    Config config = new Config();
    config.setCodec(JsonJacksonCodec(ObjectMapper.));
    config.useSingleServer()
        .setAddress("redis://localhost:6379");

    RedissonClient redissonClient = Redisson.create(config);

    return redissonClient.reactive();
  }
}
