package ecommerce.webflux.service.app.api.rest.controllers.v1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.application.commands.DeleteRateByIdCommandHandler;
import ecommerce.webflux.service.app.application.commands.RequestRateCommandHandler;
import ecommerce.webflux.service.app.application.queries.FindRateByIdQueryHandler;
import ecommerce.webflux.service.app.application.queries.FindRatesByProductBrandIdQueryHandler;
import ecommerce.webflux.service.app.domain.model.Rate;
import ecommerce.webflux.service.app.infrastructure.repositories.RateRepositoryImpl;
import ecommerce.webflux.service.app.repositories.RateRepository;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
@ContextConfiguration
class RateApiControllerIt {

  @MockBean
  private FindRateByIdQueryHandler findRateByIdQueryHandler;

  @MockBean
  private FindRatesByProductBrandIdQueryHandler findRatesByProductBrandIdQueryHandler;

  @MockBean
  private RequestRateCommandHandler requestRateCommandHandler;

  @MockBean
  private DeleteRateByIdCommandHandler deleteRateByIdCommandHandler;

  @SpyBean
  private RateDtoMapper rateDtoMapper;

  @Autowired
  private WebTestClient testClient;

  @Autowired
  private RateRepository rateRepository;

  @Test
  void addRate_ShouldReturnCreated_WhenSucess() {

    RateDto rateDto = RateObjectMother.rateDto();

    testClient.post().uri("/v1/rate/")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON)
        .body(Mono.just(rateDto), RateDto.class)
        .exchange()
        .expectStatus().isCreated()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBody(RateDto.class)
        .consumeWith(response -> {
          RateDto responseBody = response.getResponseBody();
          assertThat(responseBody).isNotNull();
          assertThat(responseBody.getId()).isNotEmpty();
          assertThat(responseBody.getId()).isNotEmpty();
          assertThat(responseBody.getPrice()).isEqualTo(1532);
          assertThat(responseBody.getBrandId()).isEqualTo("1");
          assertThat(responseBody.getProductId()).isEqualTo("1");
        });
  }

  @Test
  void findRateById_ShouldReturnRate_WhenSuccess() {

    Rate rate = rateRepository.findById("1").block();

    testClient.get()
        .uri("/v1/rate/1")
        .accept(APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(APPLICATION_JSON)
        .expectBody(Rate.class)
        .consumeWith(response -> {
          Rate responseBody = response.getResponseBody();
          assertThat(responseBody).isNotNull();
          assertThat(responseBody.getId()).isNotZero();
          assertThat(responseBody).isEqualTo(rate);
        });
  }


  @Test
  void deleteById() {

  }

  @Test
  void findRateByProductAndBrand_ShouldReturnRatesByProductAndBrandId_WhenExistsAfterADateGiven() {

    Flux<Rate> rates = rateRepository.findByProductAndBrandId("1", "1", LocalDate.of(2021, 12, 31));

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
          assertThat(responseBody.size()).isEqualTo(rates.collectList().map(List::size));
        });
  }


  @Test
  void updateRateById() {
  }

}