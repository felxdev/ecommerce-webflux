package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.domain.exceptions.RateInvalidDataException;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RequestRateCommandHandler implements CommandReturnHandler<Rate, Mono<Rate>> {

  private final RateRepository rateRepository;

  private final CurrencyService currencyService;

  @Override
  public void execute(Rate rate) {
    this.executeAndReturn(rate);
  }

  @Override
  public Mono<Rate> executeAndReturn(Rate rate) {

    if (ObjectUtils.isEmpty(rate)) {
      throw new RateInvalidDataException("Error in request rate, data is null.");
    }

    return rateRepository.save(rate);
  }
}
