package ecommerce.webflux.service.app.domain.exceptions;

import static ecommerce.webflux.service.app.domain.model.ApplicationExceptionCode.RATE_NOT_FOUND_EXCEPTION;

public class RateNotFoundException extends ApplicationException {

  public RateNotFoundException(String id) {
    super(RATE_NOT_FOUND_EXCEPTION, String.format("Not found rate by id: '%s'", id));
  }
}
