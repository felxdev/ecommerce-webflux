package ecommerce.webflux.app.application.commands;

public interface CommandHandler<T> {

  void execute(T command);
}
