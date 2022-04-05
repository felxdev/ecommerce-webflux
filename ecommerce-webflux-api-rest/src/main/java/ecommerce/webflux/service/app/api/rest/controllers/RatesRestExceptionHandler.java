package ecommerce.webflux.service.app.api.rest.controllers;

import ecommerce.webflux.service.app.api.rest.dtos.v1.ErrorDto;
import ecommerce.webflux.service.app.domain.exceptions.ApplicationException;
import ecommerce.webflux.service.app.domain.exceptions.CurrencyNotFoundException;
import ecommerce.webflux.service.app.domain.exceptions.RateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.handler.WebFluxResponseStatusExceptionHandler;

@Slf4j
@ControllerAdvice
public class RatesRestExceptionHandler{

  private ErrorDto createErrorDto(ApplicationException applicationException){
    return createErrorDto(applicationException.getApplicationExceptionCode().getErrorCode(), applicationException.getMessage());
  }

  private ErrorDto createErrorDto(Integer code, String message) {
    ErrorDto errorDto = new ErrorDto();
    errorDto.setCode(code);
    errorDto.setMessage(message);
    return errorDto;
  }

  @ExceptionHandler(value = {RateNotFoundException.class})
  protected ResponseEntity<Object> handleContractNotFoundException(RateNotFoundException rateNotFoundException) {
    log.error(ExceptionUtils.getStackTrace(rateNotFoundException));
    return new ResponseEntity<>(createErrorDto(rateNotFoundException), HttpStatus.NOT_FOUND);
  }
}
