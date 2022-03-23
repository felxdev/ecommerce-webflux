package ecommerce.webflux.service.app.infrastructure.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class RateRepositoryImpl implements RateRepository {


  private final RateRepositoryR2dbc rateRepositoryR2dbc;

  @Override
  public Mono<Rate> save(Rate rateData) {
    return rateRepositoryR2dbc.save(rateData);
  }

  @Override
  public Mono<Rate> findById(String id) {
    return rateRepositoryR2dbc.findById(id);
  }

  @Override
  public Mono<Rate> findByProductAndBrandId(String productId, String brandId, LocalDate date) {
    return rateRepositoryR2dbc.findByProductIdAndBrandIdAndStartDateAfter(productId, brandId, date);
  }

  @Override
  public Mono<Void> delete(String id) {
    return rateRepositoryR2dbc.deleteById(id);
  }

}
