package ecommerce.webflux.service.app.domain.exceptions;

public class UnavailableCurrencyServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UnavailableCurrencyServiceException(Throwable throwable){
    super(String.format("Unavailable currency service", throwable));
  }
}
