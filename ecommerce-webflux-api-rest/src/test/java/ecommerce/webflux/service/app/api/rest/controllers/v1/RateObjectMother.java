package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.api.rest.dtos.v1.AmountRequestDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
//import ecommerce.webflux.service.app.api.rest.dtos.v1.Amount;
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

  public static RateDto rateDto() {
    RateDto rateDto = new RateDto();
    rateDto.setBrandId("1");
    rateDto.setProductId("1");
    rateDto.setAmount(amount());
    rateDto.setPrice(1532);
    rateDto.setStartDate(LocalDate.of(2023, 12, 22));
    rateDto.setEndDate(LocalDate.of(2023, 12, 23));
    return rateDto;
  }

  /*public static Amount amount() {
    Amount amount = new Amount();
    amount.setCode("EUR");
    amount.setDecimals(2);
    amount.setSymbol("€");
    return amount;
  }*/

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
