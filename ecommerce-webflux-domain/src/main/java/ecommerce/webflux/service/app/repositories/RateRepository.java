package ecommerce.webflux.service.app.repositories;

import ecommerce.webflux.service.app.domain.model.Rate;

public interface RateRepository {

  Rate save(Rate rateData);

  Rate findById(String id);
}
