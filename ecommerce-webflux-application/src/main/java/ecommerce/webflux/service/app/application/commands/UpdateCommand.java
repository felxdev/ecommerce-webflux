package ecommerce.webflux.service.app.application.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCommand implements Command{

  private String id;

  private Integer price;

  private String currencyCode;
}
