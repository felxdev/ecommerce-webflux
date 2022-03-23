package ecommerce.webflux.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByProductBrandIdQueryHandler implements QueryHandler<FindRateByProductBrandIdQuery, Mono<Rate>>{

  private final RateRepository rateRepository;

  @Override
  public Mono<Rate> execute(FindRateByProductBrandIdQuery query) {
    return rateRepository.findByProductAndBrandId(query.getProductId(), query.getBrandId(), query.getDate());
  }
}
