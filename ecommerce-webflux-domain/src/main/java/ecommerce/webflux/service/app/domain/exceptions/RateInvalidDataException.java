package ecommerce.webflux.service.app.domain.exceptions;

public class RateInvalidDataException extends RuntimeException {

  public RateInvalidDataException(String data) {
    super(String.format("The rate data:'%s' is invalid.", data));
  }
}
