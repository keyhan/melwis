package se.pensionsmyndigheten.melwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.pensionsmyndigheten.melwis.domain.Arende;
import se.pensionsmyndigheten.melwis.repository.ArendeRepository;
import se.pensionsmyndigheten.melwis.repository.HandlingRepository;
import se.pensionsmyndigheten.melwis.repository.PersonRepository;

@RestController
@RequestMapping("/arende")
public class ArendeController {
  @Autowired
  private ArendeRepository arendeRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private HandlingRepository handlingRepository;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void addArende(@RequestBody Arende arende) {
    if (arende.getPersonNummer() != null && !arende.getPersonNummer().isEmpty()) {
      arende.setPerson(personRepository.findByPersonNummer(arende.getPersonNummer()));
    }
    if (arende.getHandlingsNummers() != null && !arende.getHandlingsNummers().isEmpty()) {
      arende.setHandlings(handlingRepository.findAllByHandlingsNummer(arende.getHandlingsNummers()) );
    }
    arendeRepository.save(arende);
  }


}
