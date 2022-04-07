package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.AmountDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.AmountRequestDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateRequestDto;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import java.time.LocalDate;

public class RateObjectMother {

  public static Rate rate() {
    Rate rate = new Rate();
    rate.setBrandId(1);
    rate.setProductId(1);
    rate.setCurrencyCode("EUR");
    rate.setPrice(1532);
    rate.setStartDate(LocalDate.of(2023, 12, 22));
    rate.setEndDate(LocalDate.of(2023, 12, 23));
    return rate;
  }

  public static RateRequestDto rateRequestDto() {
    RateRequestDto rateRequestDto = new RateRequestDto();
    rateRequestDto.setBrandId("1");
    rateRequestDto.setProductId("1");
    rateRequestDto.setPrice(1532);
    rateRequestDto.setStartDate(LocalDate.of(2023, 12, 22));
    rateRequestDto.setEndDate(LocalDate.of(2023, 12, 23));
    rateRequestDto.setCurrencyCode("EUR");
    return rateRequestDto;
  }

  public static AmountDto amountDto() {
    AmountDto amountDto = new AmountDto();
    amountDto.setCode("EUR");
    amountDto.setDecimals(2);
    amountDto.setSymbol("€");
    return amountDto;
  }

  public static Amount amount() {
    Amount amount = new Amount();
    amount.setCode("EUR");
    amount.setDecimals(2);
    amount.setSymbol("€");
    return amount;
  }

  public static AmountRequestDto amountRequestDto() {
    AmountRequestDto amountRequestDto = new AmountRequestDto();
    amountRequestDto.setPrice(1532);
    amountRequestDto.setCode("EUR");
    return  amountRequestDto;
  }

}
