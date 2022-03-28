package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByIdQueryHandler implements QueryHandler<FindRateByIdQuery, Mono<Rate>>{

  private final RateRepository rateRepository;
  
  private final CurrencyService currencyService;

  private final FindCurrencyByCodeQueryHandler findCurrencyByCodeQueryHandler;

  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {

    Mono<Rate> rate = this.rateRepository.findById(query.getRateId());
    Mono<Amount> amount = getAndCheckAmount(rate);

    return rate.zipWith(amount, (r, am) -> {
      r.setAmount(am);
      return r;
    });
  }

  private Mono<Amount> getAndCheckAmount(Mono<Rate> rate) {
    return rate.map(Rate::getCurrencyCode)
        .flatMap(s -> {
          Optional<Mono<Amount>> amountByCode = currencyService.getAmountByCurrencyCode(s);

          if (amountByCode.isEmpty()) {
            return Mono.error(new CurrencyNotFoundException(s));
          }
          return amountByCode.get();
        });
  }

}
