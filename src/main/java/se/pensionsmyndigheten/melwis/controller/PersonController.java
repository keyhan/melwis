package se.pensionsmyndigheten.melwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.pensionsmyndigheten.melwis.domain.Person;
import se.pensionsmyndigheten.melwis.domain.PersonDto;
import se.pensionsmyndigheten.melwis.domain.mapper.MelwisMapper;
import se.pensionsmyndigheten.melwis.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired private PersonRepository personRepository;

  @Autowired private MelwisMapper melwisMapper;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void addPerson(@RequestBody PersonDto personDto) {
      final Person person = melwisMapper.personDtoToPerson(personDto);
      final Person partner = person.getPartner();
      if (partner != null) {
          partner.setPartner(person);
          partner.setCivilstand(person.getCivilstand());
          personRepository.saveAll(Arrays.asList(partner, person));
      } else {
          personRepository.save(person);
      }

  }

  @GetMapping(path="/{personNummer}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Person getPerson(@PathVariable String personNummer) {
    return personRepository.findByPersonNummer(personNummer);
  }

  @GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Person> getAll() {
    return personRepository.findAll();
  }
}
