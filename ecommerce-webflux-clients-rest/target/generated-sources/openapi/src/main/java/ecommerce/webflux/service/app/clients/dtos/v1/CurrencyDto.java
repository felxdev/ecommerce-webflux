/*
 * Currency Api
 * Handle the info about currencies in platform
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package ecommerce.webflux.service.app.clients.dtos.v1;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.hibernate.validator.constraints.*;

/**
 * CurrencyDto
 */
@JsonPropertyOrder({
  CurrencyDto.JSON_PROPERTY_SYMBOL,
  CurrencyDto.JSON_PROPERTY_CODE,
  CurrencyDto.JSON_PROPERTY_DECIMALS
})
@JsonTypeName("Currency")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-26T15:13:13.517311300+01:00[Europe/Madrid]")
public class CurrencyDto implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SYMBOL = "symbol";
  private String symbol;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_DECIMALS = "decimals";
  private Integer decimals;

  public CurrencyDto() { 
  }

  public CurrencyDto symbol(String symbol) {
    
    this.symbol = symbol;
    return this;
  }

   /**
   * Get symbol
   * @return symbol
  **/
  @javax.annotation.Nonnull
  @NotNull
  @ApiModelProperty(example = "€", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSymbol() {
    return symbol;
  }


  @JsonProperty(JSON_PROPERTY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }


  public CurrencyDto code(String code) {
    
    this.code = code;
    return this;
  }

   /**
   * ISO Code of the currency
   * @return code
  **/
  @javax.annotation.Nonnull
  @NotNull
  @ApiModelProperty(example = "EUR", required = true, value = "ISO Code of the currency")
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(String code) {
    this.code = code;
  }


  public CurrencyDto decimals(Integer decimals) {
    
    this.decimals = decimals;
    return this;
  }

   /**
   * Get decimals
   * @return decimals
  **/
  @javax.annotation.Nonnull
  @NotNull
  @ApiModelProperty(example = "2", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DECIMALS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getDecimals() {
    return decimals;
  }


  @JsonProperty(JSON_PROPERTY_DECIMALS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDecimals(Integer decimals) {
    this.decimals = decimals;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyDto currency = (CurrencyDto) o;
    return Objects.equals(this.symbol, currency.symbol) &&
        Objects.equals(this.code, currency.code) &&
        Objects.equals(this.decimals, currency.decimals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, code, decimals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyDto {\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    decimals: ").append(toIndentedString(decimals)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

