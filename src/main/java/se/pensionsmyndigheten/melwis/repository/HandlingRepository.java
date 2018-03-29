package se.pensionsmyndigheten.melwis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.pensionsmyndigheten.melwis.domain.Handling;

import java.util.List;

public interface HandlingRepository extends MongoRepository<Handling, Long> {
  Handling findByHandlingsNummer(String handlingsNummer);
  List<Handling> findAllByHandlingsNummer(List<String> handlingsNummers);
}
