package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindCurrencyByCodeQueryHandler implements QueryHandler<FindCurrencyByCodeQuery, Mono<Amount>> {

  private final CurrencyService currencyService;

  @Override
  public Mono<Amount> execute(FindCurrencyByCodeQuery query) {

    String currencyCode = query.getCurrencyCode();

    return currencyService.getAmountByCurrencyCode(currencyCode)
        .switchIfEmpty(Mono.error(new CurrencyNotFoundException(currencyCode)));
  }
}
