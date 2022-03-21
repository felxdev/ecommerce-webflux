package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.app.application.commands.RequestRateCommandHandler;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.domain.model.Rate;
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
      RequestMethod.GET,
      RequestMethod.DELETE,
      RequestMethod.POST,
      RequestMethod.PUT
  })
public class RateApiController implements RateApi{

  private final RateDtoMapper rateDtoMapper;

  private final RequestRateCommandHandler requestRateCommandHandler;

  @Override
  public Mono<ResponseEntity<RateDto>> addRate(Mono<RateDto> rateDto, ServerWebExchange exchange) {
    log.debug("Add rate from {}", rateDto);
    Mono<Rate> rate = rateDtoMapper.asRate(rateDto);

    this.requestRateCommandHandler.executeAndReturn(rate);
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
