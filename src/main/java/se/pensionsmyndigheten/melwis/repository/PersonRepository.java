package se.pensionsmyndigheten.melwis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.pensionsmyndigheten.melwis.domain.Person;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
  Person findByPersonNummer(String personNummer);

  Person findByPartner(Person partner);

  List<Person> findAllByPersonNummer(List<String> personNummers);
}
