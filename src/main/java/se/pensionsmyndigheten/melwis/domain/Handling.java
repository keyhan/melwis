package se.pensionsmyndigheten.melwis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "Handlingar")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Handling {
  @Id
  @NonNull
  private String handlingsNummer;

private Status status;

private Steg steg;

private Map<String, Byte[]> attachements;
}
