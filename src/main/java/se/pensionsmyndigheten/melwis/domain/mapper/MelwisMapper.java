package se.pensionsmyndigheten.melwis.domain.mapper;

import se.pensionsmyndigheten.melwis.domain.*;

//@Mapper(componentModel = "spring")
public interface MelwisMapper {

    Arende arendeDtoToArende(ArendeDto arendeDto);

    Handling handlingDtoToHandling(HandlingDto handlingDto);

    Person personDtoToPerson(PersonDto personDto);

}
