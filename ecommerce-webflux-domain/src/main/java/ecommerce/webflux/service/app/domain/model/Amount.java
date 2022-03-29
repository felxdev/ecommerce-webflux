package ecommerce.webflux.service.app.domain.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
public class Amount implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String symbol;

  private String code;

  private Integer decimals;
}
