package ecommerce.webflux.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.domain.exceptions.RateInvalidDataException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestRateCommandHandler implements CommandReturnHandler<Rate, Rate>{

//  private final RateService rateService;
  @Override
  public Rate executeAndReturn(Rate rate) {
    log.debug("Request rate: {}", rate);

    /*try {
      if (ObjectUtils.isEmpty(rate)) {
        throw new RateInvalidDataException("Error in request rate, data is null.");
      }
      rateService.save
    }*/

    return null;
  }

  @Override
  public void execute(Rate command) {

  }
}
