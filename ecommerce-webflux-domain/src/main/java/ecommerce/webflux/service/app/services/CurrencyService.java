package ecommerce.webflux.service.app.services;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import java.util.Optional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyService {

  Optional<Mono<Amount>> getAmountByCurrencyCode(String currencyCode);
  Flux<Currency> findCurrencies();

}
