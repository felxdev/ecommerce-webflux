package ecommerce.webflux.service.app.application.commands;

public interface CommandReturnHandler<T, V> extends CommandHandler<T> {

  V executeAndReturn(T command);
}
