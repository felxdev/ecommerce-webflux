package ecommerce.webflux.service.app.infrastructure.repositories.entitydb;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "myschema.t_rates")
public class RateEntity {

  @Id
  private Integer id;

  private Integer brandId;

  private Integer productId;

  private Integer price;

  private LocalDate startDate;

  private LocalDate endDate;

  private String currencyCode;
}
