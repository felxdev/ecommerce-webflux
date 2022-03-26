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

  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {

    Mono<Rate> rate = this.rateRepository.findById(query.getRateId());

    Mono<Mono<Rate>> map = rate.map(r -> {

      String currencyCode = r.getCurrencyCode();
      Optional<Mono<Amount>> amountByCode = currencyService.getAmountByCurrencyCode(currencyCode);

      if (amountByCode.isEmpty()) {
        throw new CurrencyNotFoundException(currencyCode);
      }

      return amountByCode.get();

    }).map(amountMono -> amountMono.zipWith(rate, (am, ra) -> {
      am.setValue(ra.getPrice());
      ra.setAmount(am);
      return ra;
    }));

    return rate;
  }
}
