package ecommerce.webflux.service.app.services;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyService {

  Mono<Currency> getCurrencyByCode(String currencyCode);
  Flux<Currency> getCurrencies();

}
