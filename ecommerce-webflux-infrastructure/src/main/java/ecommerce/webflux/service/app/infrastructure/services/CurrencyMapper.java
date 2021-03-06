package ecommerce.webflux.service.app.infrastructure.services;

import ecommerce.webflux.service.app.clients.dtos.v1.CurrencyDto;
import ecommerce.webflux.service.app.domain.model.Amount;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CurrencyMapper {
  
  Amount currencyDtoToAmount(CurrencyDto currencyDto);

}
