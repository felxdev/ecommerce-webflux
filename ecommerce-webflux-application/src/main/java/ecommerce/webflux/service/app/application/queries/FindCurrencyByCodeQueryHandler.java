package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import ecommerce.webflux.service.app.services.CurrencyService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindCurrencyByCodeQueryHandler implements QueryHandler<FindCurrencyByCodeQuery, Optional<Mono<Currency>> {

  private final CurrencyService currencyService;

  @Override
  public Optional<Mono<Currency>> execute(FindCurrencyByCodeQuery query) {
    return Optional.empty();
  }
}
