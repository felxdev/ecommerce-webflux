package ecommerce.webflux.service.app.domain.model;

import lombok.Data;

@Data
public class Amount {

  private String symbol;

  private String code;

  private Integer decimals;
}
