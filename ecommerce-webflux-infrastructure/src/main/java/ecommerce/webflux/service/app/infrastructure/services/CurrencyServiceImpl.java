package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;
import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.exceptions.UnavailableCurrencyServiceException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
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

  private static final CurrencyMapper currencyMapper = CurrencyMapper.INSTANCE;

  private final CurrenciesApi currenciesApi;

  @Override
  public Optional<Mono<Amount>> getAmountByCurrencyCode(String currencyCode) throws CurrencyNotFoundException {

    try {
      return Optional.of(this.currenciesApi.getCurrencyByCode(currencyCode)

          .onErrorResume(e -> {
            if (e instanceof WebClientResponseException er && er.getStatusCode() == HttpStatus.NOT_FOUND) {
              throw new CurrencyNotFoundException(currencyCode);
            }
            throw new UnavailableCurrencyServiceException(e);
          })

          .map(currencyMapper::currencyDtoToAmount));
    } catch (CurrencyNotFoundException currencyNotFoundException) {
      return Optional.empty();
    }

  }

  @Override
  public Flux<Currency> findCurrencies() {
    return currenciesApi.getCurrencies().map(currencyMapper::currencyDtoToCurrency);
  }
}
