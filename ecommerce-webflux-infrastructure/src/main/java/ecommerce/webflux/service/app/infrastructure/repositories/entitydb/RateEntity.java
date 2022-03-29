package ecommerce.webflux.service.app.infrastructure.repositories.entitydb;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "myschema.t_rates")
public class RateEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private Integer id;

  private Integer brandId;

  private Integer productId;

  private Integer price;

  private LocalDate startDate;

  private LocalDate endDate;

  private String currencyCode;
}
