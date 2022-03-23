package ecommerce.webflux.app.application.queries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindRateByIdQuery implements Query {
  private String rateId;
}
