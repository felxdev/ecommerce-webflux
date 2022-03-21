package ecommerce.webflux.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Rate;
import reactor.core.publisher.Mono;

public interface CommandReturnHandler<T, V> extends CommandHandler<T> {

  V executeAndReturn(Mono<T> command);
}
