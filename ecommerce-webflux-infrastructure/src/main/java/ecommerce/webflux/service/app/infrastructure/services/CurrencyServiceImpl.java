package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;
import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.exceptions.UnavailableCurrencyServiceException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.services.CurrencyService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyMapper currencyMapper;

  private final CurrenciesApi currenciesApi;

  @Override
  public Mono<Amount> getAmountByCurrencyCode(String currencyCode) throws CurrencyNotFoundException {

      return this.currenciesApi.getCurrencyByCode(currencyCode)
          .map(currencyMapper::currencyDtoToAmount)
          .switchIfEmpty(Mono.error(new CurrencyNotFoundException(currencyCode)));
  }

  @Override
  public Flux<Amount> findCurrencies() {
    return currenciesApi.getCurrencies().map(currencyMapper::currencyDtoToAmount);
  }
}
