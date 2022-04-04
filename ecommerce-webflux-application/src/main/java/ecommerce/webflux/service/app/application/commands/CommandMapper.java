package ecommerce.webflux.service.app.application.commands;

import ecommerce.webflux.service.app.domain.model.Rate;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CommandMapper {

  Rate asRate(AddRateCommand addRateCommand);

  AddRateCommand asAddRateCommand(Rate rate);

  UpdateCommand asUpdateCommand(Rate rate);
}
