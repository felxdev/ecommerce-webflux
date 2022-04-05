package ecommerce.webflux.service.app.domain.model;

import lombok.Getter;

public enum ApplicationExceptionCode {
  RATE_NOT_FOUND_EXCEPTION(1),
  CURRENCY_NOT_FOUND_EXCEPTION(2);

  @Getter
  private final int errorCode;

  ApplicationExceptionCode(int errorCode) {
    this.errorCode = errorCode;
  }
}
