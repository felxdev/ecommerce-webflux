package ecommerce.webflux.app.application.commands;

import ecommerce.webflux.service.app.domain.exceptions.RateInvalidDataException;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RequestRateCommandHandler implements CommandReturnHandler<Rate, Mono<Rate>> {

  private final RateRepository rateRepository;

  @Override
  public void execute(Rate command) {
    this.executeAndReturn(command);
  }

  @Override
  public Mono<Rate> executeAndReturn(Rate rate) {

    if (ObjectUtils.isEmpty(rate)) {
      throw new RateInvalidDataException("Error in request rate, data is null.");
    }

    return rateRepository.save(rate);
  }
}
