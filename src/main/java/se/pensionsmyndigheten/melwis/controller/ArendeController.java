package se.pensionsmyndigheten.melwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.pensionsmyndigheten.melwis.domain.Arende;
import se.pensionsmyndigheten.melwis.domain.ArendeDto;
import se.pensionsmyndigheten.melwis.domain.Handling;
import se.pensionsmyndigheten.melwis.domain.HandlingDto;
import se.pensionsmyndigheten.melwis.domain.mapper.MelwisMapper;
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

  @Autowired
  private MelwisMapper melwisMapper;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void addArende(@RequestBody ArendeDto arendeDto) {
    final Arende arende = melwisMapper.arendeDtoToArende(arendeDto);
    arendeRepository.save(arende);
    handlingRepository.saveAll(arende.getHandlings());
  }

  @PostMapping(path="/{arendeId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addHandlingToArende(@PathVariable String arendeId, @RequestBody HandlingDto handlingDto) {
        arendeRepository.findById(arendeId).map(arende -> {
            final Handling handling = melwisMapper.handlingDtoToHandling(handlingDto);
            arende.getHandlings().add(handling);
            arendeRepository.save(arende);
            handlingRepository.save(handling);
            return true;
        });
    }





}
