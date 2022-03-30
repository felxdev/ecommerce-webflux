package ecommerce.webflux.service.app.api.rest.controllers.v1;

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
    rateDto.setCurrencyCode("EUR");
    rateDto.setPrice(1532);
    rateDto.setEndDate(LocalDate.of(2023, 12, 23));
    return rateDto;
  }

}