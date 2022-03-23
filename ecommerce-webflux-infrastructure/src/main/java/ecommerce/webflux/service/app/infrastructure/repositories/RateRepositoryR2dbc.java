package ecommerce.webflux.service.app.infrastructure.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;
import java.time.LocalDate;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RateRepositoryR2dbc extends ReactiveCrudRepository<Rate, String> {

  Mono<Rate> findByProductIdAndBrandIdAndBirthDateAfter(String productId, String brandId, LocalDate date);
}
