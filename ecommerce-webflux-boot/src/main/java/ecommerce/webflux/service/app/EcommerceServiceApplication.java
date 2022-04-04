package ecommerce.webflux.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
@EnableCaching
public class EcommerceServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcommerceServiceApplication.class, args);
  }

}
