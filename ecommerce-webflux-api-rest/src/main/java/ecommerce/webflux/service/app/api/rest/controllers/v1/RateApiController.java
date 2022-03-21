package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
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
  public Mono<ResponseEntity<RateDto>> addRate(Mono<RateDto> rateDto, ServerWebExchange exchange) {
    return RateApi.super.addRate(rateDto, exchange);
  }

  @Override
  public Mono<ResponseEntity<RateDto>> findRateById(String id, ServerWebExchange exchange) {
    return RateApi.super.findRateById(id, exchange);
  }

  @Override
  public Mono<ResponseEntity<RateDto>> findRateByProductAndBrand(OffsetDateTime startDate, String brandId, String productId,
      ServerWebExchange exchange) {
    return RateApi.super.findRateByProductAndBrand(startDate, brandId, productId, exchange);
  }

  @Override
  public Mono<ResponseEntity<RateDto>> updateRateById(String id, Mono<RateDto> body, ServerWebExchange exchange) {
    return RateApi.super.updateRateById(id, body, exchange);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteById(String id, ServerWebExchange exchange) {
    return RateApi.super.deleteById(id, exchange);
  }
}
