package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.domain.model.Rate;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RateDtoMapper {

  RateDtoMapper INSTANCE = Mappers.getMapper(RateDtoMapper.class);

  Rate rateDtoToRate(RateDto rateDto);

  default Mono<Rate> asRate(Mono<RateDto> rateDto){
    return rateDto.map(this::rateDtoToRate);
  }
}
