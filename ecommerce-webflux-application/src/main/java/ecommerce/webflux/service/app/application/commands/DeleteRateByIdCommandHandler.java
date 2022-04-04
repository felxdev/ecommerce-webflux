package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteRateByIdCommandHandler implements CommandReturnHandler<DeleteRateCommand, Mono<Void>>{

  private final RateRepository rateRepository;

  @Override
  public void execute(DeleteRateCommand rateId) {
    this.executeAndReturn(rateId);
  }

  @Override
  public Mono<Void> executeAndReturn(DeleteRateCommand deleteRateCommand) {
    return rateRepository.delete(deleteRateCommand.getId());
  }

}
