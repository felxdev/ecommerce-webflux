package ecommerce.webflux.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Rate;
import reactor.core.publisher.Mono;

public interface CommandHandler<T> {

  void execute(Mono<T> command);
}
