package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.dtos.v1.CurrencyDto;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import org.mapstruct.factory.Mappers;

public interface CurrencyMapper {

  CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);
  
  Amount currencyDtoToAmount(CurrencyDto currencyDto);

  Currency currencyDtoToCurrency(CurrencyDto currenciesDto);
}
