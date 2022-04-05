package ecommerce.webflux.service.app.domain.exceptions;

import ecommerce.webflux.service.app.domain.model.ApplicationExceptionCode;
import lombok.Getter;

public class ApplicationException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  @Getter
  private ApplicationExceptionCode applicationExceptionCode;

  public ApplicationException(ApplicationExceptionCode applicationExceptionCode, String message) {
    super(message);
    this.applicationExceptionCode = applicationExceptionCode;
  }
}
