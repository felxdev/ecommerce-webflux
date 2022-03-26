package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.model.Currency;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByIdQueryHandler implements QueryHandler<FindRateByIdQuery, Mono<Rate>>{

  private final RateRepository rateRepository;
  
  private final CurrencyService currencyService;

  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {

    /*Mono<Rate> rate = this.rateRepository.findById(query.getRateId());
    rate.map(r -> {

      String currencyCode = r.getCurrencyCode();
      Optional<Mono<Currency>> currencyByCode = currencyService.findCurrencyByCode(currencyCode);

      if (currencyByCode.isEmpty()) {
        throw new CurrencyNotFoundException(currencyCode);
      }

      r.setPrice();
    });

    if (optionalMono.flatMap(currencyMono -> {
      currencyMono.get().map(currency -> currency.)isEmpty()
    })) {
      throw new CurrencyNotFoundException(rate1.getCurrencyCode());
    }

    Mono<Optional<Mono<Currency>>> map = rate.map(r -> r.getCurrencyCode())
        .map(currencyService::findCurrencyByCode);
*/
    return null;
  }
}
