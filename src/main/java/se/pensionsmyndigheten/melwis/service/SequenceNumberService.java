package se.pensionsmyndigheten.melwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.pensionsmyndigheten.melwis.domain.SequenceNumber;
import se.pensionsmyndigheten.melwis.repository.SequenceNumberRepository;

import java.time.YearMonth;
import java.util.Optional;

@Service
public class SequenceNumberService {

    @Autowired
    private SequenceNumberRepository sequenceNumberRepository;

    public String getNextSequence(String documentName) {
        final Optional<SequenceNumber> sequenceNumber = sequenceNumberRepository.findById(documentName);
        final SequenceNumber.SequenceNumberBuilder sequenceNumberBuilder = SequenceNumber.builder();
        if (sequenceNumber.isPresent()) {
                sequenceNumberBuilder
                        .documentName(documentName)
                        .yearMonth(YearMonth.now());
                if(sequenceNumber.get().getYearMonth().equals(YearMonth.now())) {
                    sequenceNumberBuilder.sequence(sequenceNumber.get().getSequence() + 1);
                } else {
                    sequenceNumberBuilder.sequence(1);
                }

        } else {
            sequenceNumberBuilder.documentName(documentName)
                .yearMonth(YearMonth.now()).sequence(1).build().toString();
        }
        final SequenceNumber resultNumber = sequenceNumberBuilder.build();
        sequenceNumberRepository.save(resultNumber);
        return resultNumber.toString();
    }
}
