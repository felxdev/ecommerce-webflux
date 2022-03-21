package ecommerce.webflux.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Rate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestRateCommandHandler implements CommandReturnHandler<Rate, Rate>{

  @Override
  public void execute(Mono<Rate> command) {
    this.executeAndReturn(command);
  }

  @Override
  public Rate executeAndReturn(Mono<Rate> command) {
    log.debug("Request rate: {}", command);


    return null;
  }
}
