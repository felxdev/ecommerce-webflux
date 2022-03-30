package ecommerce.webflux.service.app.application.queries;

import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.repositories.RateRepository;
import ecommerce.webflux.service.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindRateByIdQueryHandler implements QueryHandler<FindRateByIdQuery, Mono<Rate>> {

  private final RateRepository rateRepository;

  private final CurrencyService currencyService;

  @Override
  public Mono<Rate> execute(FindRateByIdQuery query) {

    return rateRepository.findById(query.getRateId()).log()
        .zipWhen(rate -> currencyService.getAmountByCurrencyCode(rate.getCurrencyCode()), (ra, am) -> {
              ra.setAmount(am);
              return ra;
            }
        );
  }

}
