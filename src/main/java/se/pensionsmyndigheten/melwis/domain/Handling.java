package se.pensionsmyndigheten.melwis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Handlingar")
public class Handling {
  @Id @NonNull
  private String handlingsNummer;

private Status status;

private Steg steg;

private String attachement;
}
