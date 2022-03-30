package ecommerce.webflux.service.app.services;

import ecommerce.webflux.service.app.domain.model.Amount;
import java.util.Optional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyService {

  Mono<Amount> getAmountByCurrencyCode(String currencyCode);
  Flux<Amount> findCurrencies();

}
