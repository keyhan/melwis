package se.pensionsmyndigheten.melwis.domain.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.pensionsmyndigheten.melwis.domain.*;
import se.pensionsmyndigheten.melwis.repository.ArendeRepository;
import se.pensionsmyndigheten.melwis.repository.HandlingRepository;
import se.pensionsmyndigheten.melwis.repository.PersonRepository;
import se.pensionsmyndigheten.melwis.service.SequenceNumberService;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MelwisMapperImpl implements MelwisMapper {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private HandlingRepository handlingRepository;

    @Autowired
    private ArendeRepository arendeRepository;

    @Autowired
    private SequenceNumberService sequenceNumberService;

    @Override
    public Arende arendeDtoToArende(ArendeDto arendeDto) {
        if(arendeDto == null) {
            return null;
        }
        return Arende.builder()
                .handling(handlingDtoToHandling(arendeDto.getHandlingar()))
                .arendeNummer(sequenceNumberService.getNextSequence("Ärende"))
                .kund(personRepository.findByPersonNummer(arendeDto.getPersonNummer()))
                .status(Status.STARTAD).steg(Steg.START).build();
    }

    @Override
    public Handling handlingDtoToHandling(HandlingDto handlingDto) {
        if(handlingDto == null || handlingDto.getAttatchment() == null) {
            return null;
        }
        return Handling.builder()
                .handlingsNummer(sequenceNumberService.getNextSequence("Handling"))
                .status(Status.STARTAD).steg(Steg.START)
                .attachement(handlingDto.getAttatchment())
                .build();
    }

    @Override
    public Person personDtoToPerson(PersonDto personDto) {
        if(personDto == null) {
            return null;
        }
        final Person partner = personRepository.findByPersonNummer(personDto.getPartnerPersonNummer());
        return Person.builder().civilstand(personDto.getCivilstand())
                .personNummer(personDto.getPersonNummer())
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .dob(personDto.getDob())
                .efterlevande(personRepository.findAllByPersonNummer(personDto.getEfterlevande()))
                .kundNummer(personDto.getPersonNummer() + "|1234")
                .partner(partner)
                .build();
    }
}
