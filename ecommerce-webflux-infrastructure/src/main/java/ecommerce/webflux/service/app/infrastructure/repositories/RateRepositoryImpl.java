package ecommerce.webflux.service.app.infrastructure.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.infrastructure.repositories.r2dbc.RateRepositoryR2dbcImpl;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class RateRepositoryImpl implements RateRepository {


  private final RateRepositoryR2dbcImpl rateRepositoryR2dbc;

  @Override
  public Rate save(Rate rateData) {
    return null;
  }

  @Override
  public Rate findById(String id) {
    return null;
  }
}
