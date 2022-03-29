package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByIdQueryHandler implements QueryHandler<FindRateByIdQuery, Mono<Rate>>{

  private final RateRepository rateRepository;

  private final FindCurrencyByCodeQueryHandler findCurrencyByCodeQueryHandler;


  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {

    Mono<Rate> rate = this.rateRepository.findById(query.getRateId());
    Mono<Amount> amount = getAmount(rate);

    return rate.zipWith(amount, (r, am) -> {
      r.setAmount(am);
      return r;
    });
  }

  private Mono<Amount> getAmount(Mono<Rate> rate) {
    return rate.map(Rate::getCurrencyCode)
        .flatMap(currencyCode -> findCurrencyByCodeQueryHandler.execute(
            FindCurrencyByCodeQuery.builder().currencyCode(currencyCode).build()));
  }

}
