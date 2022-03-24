package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FindRatesByProductBrandIdQueryHandler implements QueryHandler<FindRatesByProductBrandIdQuery, Flux<Rate>>{

  private final RateRepository rateRepository;

  @Override
  public Flux<Rate> execute(FindRatesByProductBrandIdQuery query) {
    return rateRepository.findByProductAndBrandId(query.getProductId(), query.getBrandId(), query.getDate());
  }
}
