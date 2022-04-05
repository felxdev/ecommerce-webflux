package ecommerce.webflux.service.app.domain.exceptions;

import static ecommerce.webflux.service.app.domain.model.ApplicationExceptionCode.CURRENCY_NOT_FOUND_EXCEPTION;

public class CurrencyNotFoundException extends ApplicationException {

  public CurrencyNotFoundException(String currencyCode) {
    super(CURRENCY_NOT_FOUND_EXCEPTION, String.format("Currency not found by currencycode: '%s'", currencyCode));
  }
}
