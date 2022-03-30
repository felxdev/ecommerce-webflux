package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.AmountDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.domain.model.Rate;
import java.time.LocalDate;

public class RateObjectMother {

  public static Rate rate() {
    Rate rate = new Rate();
    rate.setBrandId(1);
    rate.setProductId(1);
    rate.setCurrencyCode("EUR");
    rate.setPrice(1532);
    rate.setEndDate(LocalDate.of(2023, 12, 23));
    return rate;
  }

  public static RateDto rateDto() {
    RateDto rateDto = new RateDto();
    rateDto.setBrandId("1");
    rateDto.setProductId("1");
    rateDto.setAmount(amountDto());
    rateDto.setPrice(1532);
    rateDto.setEndDate(LocalDate.of(2023, 12, 23));
    return rateDto;
  }

  private static AmountDto amountDto() {
    AmountDto amountDto = new AmountDto();
    amountDto.setCode("EUR");
    amountDto.setDecimals(2);
    amountDto.setSymbol("€");
    return amountDto;
  }

}
