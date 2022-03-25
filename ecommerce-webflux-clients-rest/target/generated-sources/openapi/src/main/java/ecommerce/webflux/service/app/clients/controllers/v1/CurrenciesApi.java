package ecommerce.webflux.service.app.clients.controllers.v1;

import ecommerce.webflux.service.app.clients.invokers.v1.ApiClient;

import ecommerce.webflux.service.app.clients.dtos.v1.CurrencyDto;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-25T15:38:32.959582100+01:00[Europe/Madrid]")
public class CurrenciesApi {
    private ApiClient apiClient;

    public CurrenciesApi() {
        this(new ApiClient());
    }

    @Autowired
    public CurrenciesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get currencies list
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Authentication is required to get the requested response
     * @return List&lt;CurrencyDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCurrenciesRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return apiClient.invokeAPI("/v1/currencies", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get currencies list
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Authentication is required to get the requested response
     * @return List&lt;CurrencyDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<CurrencyDto> getCurrencies() throws WebClientResponseException {
        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return getCurrenciesRequestCreation().bodyToFlux(localVarReturnType);
    }

    public Mono<ResponseEntity<List<CurrencyDto>>> getCurrenciesWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return getCurrenciesRequestCreation().toEntityList(localVarReturnType);
    }
    /**
     * Get currency detail
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Authentication is required to get the requested response
     * <p><b>404</b> - Currency not found
     * @param currencyCode The currency ISO code
     * @return CurrencyDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCurrencyByCodeRequestCreation(String currencyCode) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'currencyCode' is set
        if (currencyCode == null) {
            throw new WebClientResponseException("Missing the required parameter 'currencyCode' when calling getCurrencyByCode", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("currencyCode", currencyCode);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return apiClient.invokeAPI("/v1/currencies/{currencyCode}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get currency detail
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Authentication is required to get the requested response
     * <p><b>404</b> - Currency not found
     * @param currencyCode The currency ISO code
     * @return CurrencyDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CurrencyDto> getCurrencyByCode(String currencyCode) throws WebClientResponseException {
        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return getCurrencyByCodeRequestCreation(currencyCode).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<CurrencyDto>> getCurrencyByCodeWithHttpInfo(String currencyCode) throws WebClientResponseException {
        ParameterizedTypeReference<CurrencyDto> localVarReturnType = new ParameterizedTypeReference<CurrencyDto>() {};
        return getCurrencyByCodeRequestCreation(currencyCode).toEntity(localVarReturnType);
    }
}
