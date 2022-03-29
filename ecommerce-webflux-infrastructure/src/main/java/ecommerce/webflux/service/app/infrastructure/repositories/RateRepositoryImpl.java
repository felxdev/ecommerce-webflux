package ecommerce.webflux.service.app.infrastructure.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.infrastructure.repositories.entitydb.RateEntity;
import ecommerce.webflux.service.app.infrastructure.repositories.entitydb.RateEntityMapper;
import ecommerce.webflux.service.app.infrastructure.repositories.entitydb.RateRepositoryR2dbc;
import ecommerce.webflux.service.app.repositories.RateRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class RateRepositoryImpl implements RateRepository {

  private final RateRepositoryR2dbc rateRepositoryR2dbc;

  private final RateEntityMapper rateEntityMapper;

  @Override
  public Mono<Rate> save(Rate rateData) {
    RateEntity rateEntity = rateEntityMapper.rateToRateEntity(rateData);

    return rateRepositoryR2dbc.save(rateEntity)
        .map(rateEntityMapper::rateEntityToRate);
  }

  @Override
  public Mono<Rate> findById(String id) {
    return rateRepositoryR2dbc.findById(id)
        .map(rateEntityMapper::rateEntityToRate);
  }

  @Override
  public Flux<Rate> findByProductAndBrandId(String productId, String brandId, LocalDate date) {
    return rateRepositoryR2dbc.findByProductIdAndBrandIdAndStartDateAfter(productId, brandId, date)
        .map(rateEntityMapper::rateEntityToRate);
  }

  @Override
  public Mono<Void> delete(String id) {
    return rateRepositoryR2dbc.deleteById(id);
  }

}
