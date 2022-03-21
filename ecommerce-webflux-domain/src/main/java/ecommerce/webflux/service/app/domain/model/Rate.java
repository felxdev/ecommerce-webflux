package ecommerce.webflux.service.app.domain.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Rate {

  private String id;

  private String brandId;

  private String productId;

  private LocalDate startDate;

  private Integer price;

  private String currencyCode;
}
