package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.Rate;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*",
  methods = {
      RequestMethod.POST
  })
public class RateApiController implements RateApi{

  @Override
  public Mono<ResponseEntity<Rate>> addRate(Mono<Rate> rate, ServerWebExchange exchange) {
    return RateApi.super.addRate(rate, exchange);
  }

  @Override
  public Mono<ResponseEntity<Rate>> findRateById(String id, ServerWebExchange exchange) {
    return RateApi.super.findRateById(id, exchange);
  }

  @Override
  public Mono<ResponseEntity<Rate>> findRateByProductAndBrand(OffsetDateTime startDate, String brandId, String productId,
      ServerWebExchange exchange) {
    return RateApi.super.findRateByProductAndBrand(startDate, brandId, productId, exchange);
  }

  @Override
  public Mono<ResponseEntity<Rate>> updateRateById(String id, Mono<Rate> body, ServerWebExchange exchange) {
    return RateApi.super.updateRateById(id, body, exchange);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteById(String id, ServerWebExchange exchange) {
    return RateApi.super.deleteById(id, exchange);
  }
}
