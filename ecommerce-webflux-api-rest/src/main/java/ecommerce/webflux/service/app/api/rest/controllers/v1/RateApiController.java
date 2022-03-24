package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.application.commands.DeleteRateByIdCommandHandler;
import ecommerce.webflux.service.app.application.commands.RequestRateCommandHandler;
import ecommerce.webflux.service.app.application.queries.FindRateByIdQuery;
import ecommerce.webflux.service.app.application.queries.FindRateByIdQueryHandler;
import ecommerce.webflux.service.app.application.queries.FindRatesByProductBrandIdQuery;
import ecommerce.webflux.service.app.application.queries.FindRatesByProductBrandIdQueryHandler;
import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

  private final FindRateByIdQueryHandler findRateByIdQueryHandler;

  private final FindRatesByProductBrandIdQueryHandler findRatesByProductBrandIdQueryHandler;

  private final RequestRateCommandHandler requestRateCommandHandler;

  private final DeleteRateByIdCommandHandler deleteByIdCommandHandler;

  @Override
  public Mono<ResponseEntity<RateDto>> addRate(Mono<RateDto> rateDto, ServerWebExchange exchange) {

    return rateDto.map(rateDtoMapper::asRate)
        .flatMap(requestRateCommandHandler::executeAndReturn)
        .map(rateDtoMapper::rateToRateDto)
        .map(rDto -> ResponseEntity
            .created(URI.create(String.format("/v1/rate/%s", rDto.getId())))
            .body(rDto));
  }

  @Override
  public Mono<ResponseEntity<RateDto>> findRateById(String id, ServerWebExchange exchange) {

    return findRateByIdQueryHandler.execute(FindRateByIdQuery.builder().rateId(id).build())
        .map(rateDtoMapper::rateToRateDto)
        .map(rate -> ResponseEntity.ok().body(rate))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Flux<RateDto>>> findRateByProductAndBrand(OffsetDateTime startDate, String brandId, String productId,
      ServerWebExchange exchange) {

    return Mono.just(ResponseEntity.ok().body(findRatesByProductBrandIdQueryHandler
            .execute(FindRatesByProductBrandIdQuery.builder().date(LocalDate.from(startDate)).brandId(brandId).productId(productId).build())
        .map(rateDtoMapper::rateToRateDto)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteById(String id, ServerWebExchange exchange) {
    return deleteByIdCommandHandler.executeAndReturn(id)
        .thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public Mono<ResponseEntity<RateDto>> updateRateById(String id, Mono<RateDto> body, ServerWebExchange exchange) {
    return RateApi.super.updateRateById(id, body, exchange);
  }
}
