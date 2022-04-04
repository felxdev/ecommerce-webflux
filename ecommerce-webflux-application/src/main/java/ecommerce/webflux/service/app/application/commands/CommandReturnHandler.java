package ecommerce.webflux.service.app.application.commands;

import reactor.core.CorePublisher;

public interface CommandReturnHandler<T extends Command, V extends CorePublisher<?>> extends CommandHandler<T> {

  V executeAndReturn(T command);
}
