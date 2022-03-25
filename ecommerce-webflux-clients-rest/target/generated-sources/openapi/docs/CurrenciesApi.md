# CurrenciesApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCurrencies**](CurrenciesApi.md#getCurrencies) | **GET** /v1/currencies | Get currencies list
[**getCurrencyByCode**](CurrenciesApi.md#getCurrencyByCode) | **GET** /v1/currencies/{currencyCode} | Get currency detail



## getCurrencies

> List&lt;CurrencyDto&gt; getCurrencies()

Get currencies list

### Example

```java
// Import classes:
import ecommerce.webflux.service.app.clients.invokers.v1.ApiClient;
import ecommerce.webflux.service.app.clients.invokers.v1.ApiException;
import ecommerce.webflux.service.app.clients.invokers.v1.Configuration;
import ecommerce.webflux.service.app.clients.invokers.v1.auth.*;
import ecommerce.webflux.service.app.clients.invokers.v1.models.*;
import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        CurrenciesApi apiInstance = new CurrenciesApi(defaultClient);
        try {
            List<CurrencyDto> result = apiInstance.getCurrencies();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CurrenciesApi#getCurrencies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;CurrencyDto&gt;**](CurrencyDto.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **401** | Authentication is required to get the requested response |  -  |


## getCurrencyByCode

> CurrencyDto getCurrencyByCode(currencyCode)

Get currency detail

### Example

```java
// Import classes:
import ecommerce.webflux.service.app.clients.invokers.v1.ApiClient;
import ecommerce.webflux.service.app.clients.invokers.v1.ApiException;
import ecommerce.webflux.service.app.clients.invokers.v1.Configuration;
import ecommerce.webflux.service.app.clients.invokers.v1.auth.*;
import ecommerce.webflux.service.app.clients.invokers.v1.models.*;
import ecommerce.webflux.service.app.clients.controllers.v1.CurrenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        CurrenciesApi apiInstance = new CurrenciesApi(defaultClient);
        String currencyCode = "currencyCode_example"; // String | The currency ISO code
        try {
            CurrencyDto result = apiInstance.getCurrencyByCode(currencyCode);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CurrenciesApi#getCurrencyByCode");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currencyCode** | **String**| The currency ISO code |

### Return type

[**CurrencyDto**](CurrencyDto.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **401** | Authentication is required to get the requested response |  -  |
| **404** | Currency not found |  -  |

