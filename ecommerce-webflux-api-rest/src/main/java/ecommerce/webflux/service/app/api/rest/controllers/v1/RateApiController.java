package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.Rate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
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
}
