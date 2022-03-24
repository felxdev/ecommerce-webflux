package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteRateByIdCommandHandler implements CommandReturnHandler<String, Mono<Void>>{

  private final RateRepository rateRepository;

  @Override
  public void execute(String rateId) {
    this.executeAndReturn(rateId);
  }

  @Override
  public Mono<Void> executeAndReturn(String rateId) {
    return rateRepository.delete(rateId);
  }

}
