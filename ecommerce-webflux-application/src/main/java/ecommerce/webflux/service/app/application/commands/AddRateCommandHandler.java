package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.domain.exceptions.RateInvalidDataException;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddRateCommandHandler implements CommandReturnHandler<AddRateCommand, Mono<Rate>> {

  private final RateRepository rateRepository;

  private final CurrencyService currencyService;

  private final CommandMapper commandMapper;



  @Override
  public void execute(AddRateCommand addRateCommand) {
    this.executeAndReturn(addRateCommand);
  }

  @Override
  public Mono<Rate> executeAndReturn(AddRateCommand addRateCommand) {


    if (ObjectUtils.isEmpty(addRateCommand)) {
      throw new RateInvalidDataException("Error in request rate, data is null.");
    }

    Mono<Rate> saveRate = rateRepository.save(commandMapper.asRate(addRateCommand));
    Mono<Amount> amount = saveRate.flatMap(
        ra -> currencyService.getAmountByCurrencyCode(ra.getCurrencyCode()));

    return saveRate.zipWith(amount, (ra, am) -> {
      ra.setAmount(am);
      return ra;
    });
  }
}
