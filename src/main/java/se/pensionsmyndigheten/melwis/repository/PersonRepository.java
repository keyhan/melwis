package se.pensionsmyndigheten.melwis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.pensionsmyndigheten.melwis.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long>{
  Person findByPersonNummer(String personNummer);
}
