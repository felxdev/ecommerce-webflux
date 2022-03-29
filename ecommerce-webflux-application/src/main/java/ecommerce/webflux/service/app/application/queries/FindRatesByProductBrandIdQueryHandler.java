package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindRatesByProductBrandIdQueryHandler implements QueryHandler<FindRatesByProductBrandIdQuery, Flux<Rate>> {

  private final RateRepository rateRepository;

  private final FindCurrencyByCodeQueryHandler findCurrencyByCodeQueryHandler;

  @Override
  public Flux<Rate> execute(FindRatesByProductBrandIdQuery query) {

    return rateRepository.findByProductAndBrandId(query.getProductId(), query.getBrandId(), query.getDate())
        .flatMap(rate ->
            getAmountByCurrencyCode(rate).map(amount -> {
              rate.setAmount(amount);
              return rate;
            }));
  }

  private Mono<Amount> getAmountByCurrencyCode(Rate rate) {
    return findCurrencyByCodeQueryHandler.execute(FindCurrencyByCodeQuery.builder().currencyCode(rate.getCurrencyCode()).build());
  }
}
