package ecommerce.webflux.service.app.application.commands;

public interface CommandHandler<T extends Command> {

  void execute(T command);
}
