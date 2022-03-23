package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.app.application.commands.DeleteRateByIdCommandHandler;
import ecommerce.webflux.app.application.commands.RequestRateCommandHandler;
import ecommerce.webflux.app.application.queries.FindRateByIdQuery;
import ecommerce.webflux.app.application.queries.FindRateByIdQueryHandler;
import ecommerce.webflux.app.application.queries.FindRateByProductBrandIdQuery;
import ecommerce.webflux.app.application.queries.FindRateByProductBrandIdQueryHandler;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@With
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

  private final FindRateByProductBrandIdQueryHandler findRateByProductBrandIdQueryHandler;

  private final RequestRateCommandHandler requestRateCommandHandler;

  private final DeleteRateByIdCommandHandler deleteByIdCommandHandler;

  @Override
  public Mono<ResponseEntity<RateDto>> addRate(Mono<RateDto> rateDto, ServerWebExchange exchange) {

    return rateDto.map(rateDtoMapper::rateDtoToRate)
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
  public Mono<ResponseEntity<RateDto>> findRateByProductAndBrand(OffsetDateTime startDate, String brandId, String productId,
      ServerWebExchange exchange) {

    return findRateByProductBrandIdQueryHandler.execute(FindRateByProductBrandIdQuery.builder()
            .date(LocalDate.from(startDate)).brandId(brandId).productId(productId).build())
        .map(rateDtoMapper::rateToRateDto)
        .map(rate -> ResponseEntity.ok().body(rate))
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
