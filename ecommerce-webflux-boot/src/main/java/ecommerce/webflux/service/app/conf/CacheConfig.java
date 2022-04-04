package ecommerce.webflux.service.app.conf;

import ecommerce.webflux.service.app.domain.model.Rate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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


  /*@Bean
  public CacheManager cacheManager(RedissonReactiveClient redissonClient) {
    Map<String, CacheConfig> config = new HashMap<>();
    config.put("rate", new CacheConfig());
    return new RedissonSpringCacheManager(redissonClient.get);
  }

  @Bean(destroyMethod = "shutdown")
  public RedissonReactiveClient redisson() {

    Config config = new Config();
    config.setCodec(JsonJacksonCodec(ObjectMapper.));
    config.useSingleServer()
        .setAddress("redis://localhost:6379");

    RedissonClient redissonClient = Redisson.create(config);

    return redissonClient.reactive();
  }*/

  @Bean
  public ReactiveRedisTemplate<String, Rate> reactiveRedisTemplate(
      ReactiveRedisConnectionFactory factory) {
    StringRedisSerializer keySerializer = new StringRedisSerializer();
    Jackson2JsonRedisSerializer<Rate> valueSerializer =
        new Jackson2JsonRedisSerializer<>(Rate.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Rate> builder =
        RedisSerializationContext.newSerializationContext(keySerializer);
    RedisSerializationContext<String, Rate> context =
        builder.value(valueSerializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }
}
