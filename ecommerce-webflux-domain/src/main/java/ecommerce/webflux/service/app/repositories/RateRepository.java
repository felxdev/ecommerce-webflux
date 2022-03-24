package ecommerce.webflux.service.app.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;
import java.time.LocalDate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RateRepository {

  Mono<Rate> save(Rate rateData);

  Mono<Rate> findById(String id);

  Flux<Rate> findByProductAndBrandId(String productId, String brandId, LocalDate date);

  Mono<Void> delete(String id);
}
