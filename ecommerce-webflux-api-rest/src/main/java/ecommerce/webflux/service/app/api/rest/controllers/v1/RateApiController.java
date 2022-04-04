package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateRequestDto;
import ecommerce.webflux.service.app.application.commands.CommandMapper;
import ecommerce.webflux.service.app.application.commands.DeleteRateByIdCommandHandler;
import ecommerce.webflux.service.app.application.commands.DeleteRateCommand;
import ecommerce.webflux.service.app.application.commands.AddRateCommandHandler;
import ecommerce.webflux.service.app.application.commands.UpdateCommand;
import ecommerce.webflux.service.app.application.commands.UpdateCommandHandler;
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

  private final CommandMapper commandMapper;

  private final FindRateByIdQueryHandler findRateByIdQueryHandler;

  private final FindRatesByProductBrandIdQueryHandler findRatesByProductBrandIdQueryHandler;

  private final AddRateCommandHandler addRateCommandHandler;

  private final UpdateCommandHandler updateCommandHandler;

  private final DeleteRateByIdCommandHandler deleteByIdCommandHandler;

  @Override
  public Mono<ResponseEntity<RateDto>> addRate(Mono<RateRequestDto> rateDto, ServerWebExchange exchange) {

    return rateDto.map(rateDtoMapper::rateRequestDtoToRate)
        .flatMap(rate -> addRateCommandHandler.executeAndReturn(commandMapper.asAddRateCommand(rate)))
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

    return Mono.just(ResponseEntity.ok()
            .body(findRatesByProductBrandIdQueryHandler.execute(FindRatesByProductBrandIdQuery
                    .builder().date(LocalDate.from(startDate)).brandId(brandId).productId(productId).build())
        .map(rateDtoMapper::rateToRateDto)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteById(String id, ServerWebExchange exchange) {
    return deleteByIdCommandHandler.executeAndReturn(DeleteRateCommand.builder().id(id).build())
        .thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public Mono<ResponseEntity<RateDto>> updateRateById(String id, Mono<RateRequestDto> body, ServerWebExchange exchange) {

    return body.map(rateDtoMapper::rateRequestDtoToRate).flatMap(rate -> {
      UpdateCommand updateCommand = commandMapper.asUpdateCommand(rate);
      updateCommand.setId(id);

      return updateCommandHandler.executeAndReturn(updateCommand);
    }).map(rateDtoMapper::rateToRateDto)
        .map(rateDto -> ResponseEntity.ok().body(rateDto))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
