package ecommerce.webflux.app.application.queries;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindRateByProductBrandIdQuery implements Query {

  private String brandId;

  private String productId;

  private LocalDate date;
}
