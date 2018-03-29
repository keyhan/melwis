package se.pensionsmyndigheten.melwis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.pensionsmyndigheten.melwis.domain.Arende;

@Repository
public interface ArendeRepository extends MongoRepository<Arende, Long> {
}
