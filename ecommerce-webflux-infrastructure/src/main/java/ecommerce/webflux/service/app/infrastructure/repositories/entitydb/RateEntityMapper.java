package ecommerce.webflux.service.app.infrastructure.repositories.entitydb;

import ecommerce.webflux.service.app.domain.model.Rate;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RateEntityMapper {

  RateEntity rateToRateEntity(Rate rate);

  Rate rateEntityToRate(RateEntity rateEntity);
}
