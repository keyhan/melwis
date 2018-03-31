package se.pensionsmyndigheten.melwis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.pensionsmyndigheten.melwis.domain.SequenceNumber;

@Repository
public interface SequenceNumberRepository extends MongoRepository<SequenceNumber, String> {
}
