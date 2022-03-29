package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.services.CurrencyService;
import java.util.Optional;
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

    Optional<Mono<Amount>> amountByCode = currencyService.getAmountByCurrencyCode(currencyCode);

    if (amountByCode.isEmpty()) {
      return Mono.error(new CurrencyNotFoundException(currencyCode));
    }

    return amountByCode.get();
  }
}
