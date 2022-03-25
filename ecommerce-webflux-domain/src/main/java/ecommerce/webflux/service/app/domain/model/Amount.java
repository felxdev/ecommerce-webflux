package ecommerce.webflux.service.app.domain.model;

import lombok.Data;

@Data
public class Amount {

  private String code;

  private String symbol;

  private Integer decimals;

  private Integer value;
}
