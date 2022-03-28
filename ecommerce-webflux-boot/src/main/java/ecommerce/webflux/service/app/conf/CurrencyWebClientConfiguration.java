package ecommerce.webflux.service.app.conf;

import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;
import ecommerce.webflux.service.app.clients.invokers.v1.ApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CurrencyWebClientConfiguration {

  @Value("${ecommerce-webflux-service.rest.client.currency-service-api-rest}")
  private String currencyUrl;

  @Bean
  WebClient currencyWebClient() {
    return ApiClient.buildWebClient();
  }

  @Bean
  ApiClient customCurrencyApiClient(@Qualifier("currencyWebClient") WebClient webClient) {
    ApiClient apiClient = new ApiClient(webClient);
    apiClient.setBasePath(currencyUrl);
    return apiClient;
  }

  @Bean
  CurrenciesApi currenciesApi(@Qualifier("customCurrencyApiClient") ApiClient apiClient) {
    return new CurrenciesApi(apiClient);
  }
}
