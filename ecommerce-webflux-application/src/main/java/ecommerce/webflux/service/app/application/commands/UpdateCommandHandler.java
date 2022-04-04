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

    Mono<Rate> rateBD = rateRepository.findById(command.getId());
    Mono<Amount> amount = rateBD.flatMap(rate -> currencyService.getAmountByCurrencyCode(rate.getCurrencyCode()));

    return rateBD.zipWith(amount, (ra, am) -> {
      ra.setAmount(am);
      ra.setPrice(command.getPrice());
      ra.setProductId(command.getProductId());
      ra.setBrandId(command.getBrandId());
      ra.setStartDate(command.getStartDate());
      ra.setEndDate(command.getEndDate());
      return ra;
    });
  }
}
