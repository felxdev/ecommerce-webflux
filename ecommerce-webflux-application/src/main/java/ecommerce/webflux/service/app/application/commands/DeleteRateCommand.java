package ecommerce.webflux.service.app.application.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteRateCommand implements Command{

  String id;
}
