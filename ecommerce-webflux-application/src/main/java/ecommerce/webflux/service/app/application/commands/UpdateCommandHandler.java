package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdateCommandHandler implements CommandReturnHandler<UpdateCommand, Mono<Rate>>{

  private final CurrencyService currencyService;

  private final RateRepository rateRepository;

  @Override
  public void execute(UpdateCommand command) {
    this.executeAndReturn(command);
  }

  @Override
  public Mono<Rate> executeAndReturn(UpdateCommand command) {

    return rateRepository.findById(command.getId())
        .zipWith(getAmountByCurrencyCode(command),
            (ra, am) -> {
      ra.setAmount(am);
      ra.setPrice(command.getPrice());
      return ra;
    });
  }

  private Mono<Amount> getAmountByCurrencyCode(UpdateCommand command) {
    return currencyService.getAmountByCurrencyCode(command.getCurrencyCode());
  }
}
