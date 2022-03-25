package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;
import ecommerce.webflux.service.app.clients.dtos.v1.CurrencyDto;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{

  private final CurrenciesApi currenciesApi;

  @Override
  public Mono<Currency> getCurrencyByCode(String currencyCode) {

    currenciesApi.getCurrencyByCode(currencyCode);
    return null;
  }

  @Override
  public Flux<Currency> getCurrencies() {
    return null;
  }
}
