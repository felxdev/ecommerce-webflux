package ecommerce.webflux.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByIdQueryHandler implements QueryHandler<FindRateByIdQuery, Mono<Rate>>{

  private final RateRepository rateRepository;

  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {
    return this.rateRepository.findById(query.getRateId());
  }
}
