package ecommerce.webflux.service.app.application.commands;

public interface CommandHandler<T> {

  void execute(T command);
}
