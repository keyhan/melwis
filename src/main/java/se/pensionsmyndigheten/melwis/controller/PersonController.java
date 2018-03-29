package se.pensionsmyndigheten.melwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.pensionsmyndigheten.melwis.domain.Person;
import se.pensionsmyndigheten.melwis.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired private PersonRepository personRepository;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void addPerson(@RequestBody Person person) {
    personRepository.save(person);
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
