package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.dtos.v1.CurrencyDto;
import ecommerce.webflux.service.app.domain.model.Amount;
import ecommerce.webflux.service.app.domain.model.Currency;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CurrencyMapper {

  CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);
  
  Amount currencyDtoToAmount(CurrencyDto currencyDto);

  Currency currencyDtoToCurrency(CurrencyDto currenciesDto);
}
