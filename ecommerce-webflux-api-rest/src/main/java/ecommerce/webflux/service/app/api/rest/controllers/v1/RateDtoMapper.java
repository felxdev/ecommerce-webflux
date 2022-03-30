package ecommerce.webflux.service.app.api.rest.controllers.v1;

import ecommerce.webflux.service.app.api.rest.dtos.v1.RateDto;
import ecommerce.webflux.service.app.api.rest.dtos.v1.RateRequestDto;
import ecommerce.webflux.service.app.domain.model.Rate;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RateDtoMapper {

  Rate rateRequestDtoToRate(RateRequestDto rateRequestDto);

  RateDto rateToRateDto(Rate rate);
}
