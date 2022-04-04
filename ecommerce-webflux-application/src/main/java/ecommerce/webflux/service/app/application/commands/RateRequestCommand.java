package ecommerce.webflux.service.app.application.commands;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateRequestCommand implements Command{

  private String id;

  private Integer brandId;

  private Integer productId;

  private Integer price;

  private LocalDate startDate;

  private LocalDate endDate;

  private String currencyCode;
}
