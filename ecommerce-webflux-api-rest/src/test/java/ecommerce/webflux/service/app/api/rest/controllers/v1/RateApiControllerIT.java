package ecommerce.webflux.service.app.api.rest.controllers.v1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import ecommerce.webflux.service.app.api.rest.dtos.v1.AmountRequestDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateRequestDto;
import ecommerce.webflux.service.app.application.commands.AddRateCommandHandler;
import ecommerce.webflux.service.app.application.commands.CommandMapperImpl;
import ecommerce.webflux.service.app.application.commands.DeleteRateByIdCommandHandler;
import ecommerce.webflux.service.app.application.commands.UpdateCommandHandler;
import ecommerce.webflux.service.app.application.queries.FindRateByIdQueryHandler;
import ecommerce.webflux.service.app.application.queries.FindRatesByProductBrandIdQueryHandler;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.infrastructure.services.CurrencyServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
@ContextConfiguration(classes = {RateApiController.class})
class RateApiControllerIT {

  @MockBean
  private FindRateByIdQueryHandler findRateByIdQueryHandler;

  @MockBean
  private FindRatesByProductBrandIdQueryHandler findRatesByProductBrandIdQueryHandler;

  @MockBean
  private AddRateCommandHandler addRateCommandHandler;

  @MockBean
  private DeleteRateByIdCommandHandler deleteRateByIdCommandHandler;

  @MockBean
  private UpdateCommandHandler updateCommandHandler;

  @MockBean
  private CurrencyServiceImpl currencyService;

  @SpyBean
  private CommandMapperImpl commandMapper;

  @SpyBean
  private RateDtoMapperImpl rateDtoMapper;

  @Autowired
  private WebTestClient testClient;

  @Test
  void addRate_ShouldReturnCreated_WhenSuccess() {

    RateRequestDto rateRequestDto = RateObjectMother.rateRequestDto();
    Rate rate = RateObjectMother.rate();

    given(addRateCommandHandler.executeAndReturn(any())).willReturn(Mono.just(rate));

    testClient.post().uri("/v1/rate/")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON)
        .body(Mono.just(rateRequestDto), RateRequestDto.class)
        .exchange()
        .expectStatus().isCreated()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBody(RateDto.class)
        .consumeWith(response -> {
          RateDto responseBody = response.getResponseBody();
          assertThat(responseBody).isNotNull();
          assertThat(responseBody.getPrice()).isEqualTo(rateRequestDto.getPrice());
          assertThat(responseBody.getBrandId()).isEqualTo(rateRequestDto.getBrandId());
          assertThat(responseBody.getProductId()).isEqualTo(rateRequestDto.getProductId());
        });
  }

  @Test
  void findRateById_ShouldReturnRate_WhenSuccess() {

    Rate rate = RateObjectMother.rate();

    given(findRateByIdQueryHandler.execute(any())).willReturn(Mono.just(rate));

    testClient.get()
        .uri("/v1/rate/1")
        .accept(APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBody(RateDto.class)
        .consumeWith(response -> {
          RateDto responseBody = response.getResponseBody();
          assertThat(responseBody).isNotNull();
        });
  }

  @Test
  void updateRateById_ShouldReturnRateUpdated_WhenSuccess() {

    AmountRequestDto amountRequestDto = RateObjectMother.amountRequestDto();
    Amount amount = RateObjectMother.amount();
    Rate rate = RateObjectMother.rate();
    rate.setId(3);

    given(updateCommandHandler.executeAndReturn(any())).willReturn(Mono.just(rate));
    given(currencyService.getAmountByCurrencyCode(any())).willReturn(Mono.just(amount));

    testClient.patch().uri("/v1/rate/3")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON)
        .body(Mono.just(amountRequestDto), AmountRequestDto.class)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBody(RateDto.class)
        .consumeWith(consume -> {
          RateDto responseRate = consume.getResponseBody();
          assertThat(responseRate).isNotNull();
          assertThat(responseRate.getPrice()).isEqualTo(amountRequestDto.getPrice());
        });
  }

  @Test
  void deleteById_ShouldReturnNoContent_WhenRateIsDeleted() {

    given(deleteRateByIdCommandHandler.executeAndReturn(any())).willReturn(Mono.empty());

    testClient.delete()
        .uri("/v1/rate/2")
        .accept(APPLICATION_JSON)
        .exchange()
        .expectStatus().isNoContent()
        .expectBody()
        .isEmpty();
  }

  @Test
  void findRateByProductAndBrand_ShouldReturnRatesByProductAndBrandId_WhenExistsAfterADateGiven() {

    Flux<Rate> rates = Flux.just(RateObjectMother.rate());

    given(findRatesByProductBrandIdQueryHandler.execute(any())).willReturn(rates);

    testClient.get()
        .uri("/v1/rate?startDate=2021-12-31T17:32:28Z&brandId=1&productId=1")
        .accept(APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBodyList(Rate.class)
        .consumeWith(response -> {
          List<Rate> responseBody = response.getResponseBody();
          assertThat(responseBody).isNotNull();
          assertThat(responseBody).hasSize(1);
        });
  }

}