package se.pensionsmyndigheten.melwis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.YearMonth;

@Document(collection = "counters")
@Data
@Builder
public class SequenceNumber {
    @Id private String documentName;
    private YearMonth yearMonth;
    private int sequence;

    @Override
    public String toString() {
        return documentName + ":" + yearMonth + "-" + sequence;
    }
}
