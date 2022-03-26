package ecommerce.webflux.service.app.domain.exceptions;

public class CurrencyNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CurrencyNotFoundException(String currencyCode){
    super(String.format("Not found any currency for '%s' code.", currencyCode));
  }
}
