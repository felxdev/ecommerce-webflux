package ecommerce.webflux.service.app.domain.exceptions;

public class RateNotFoundException extends RuntimeException {

  public RateNotFoundException(){
    super("Not found rate");
  }
}
