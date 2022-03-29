package ecommerce.webflux.service.app.application.queries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindCurrencyByCodeQuery implements Query{
  private String currencyCode;
}
