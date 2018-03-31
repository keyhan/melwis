package se.pensionsmyndigheten.melwis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Arenden")
@Data
@Builder
@ToString(exclude = {"personNummer", "handlingsNummers"})
@AllArgsConstructor
@NoArgsConstructor
public class Arende {
  @DBRef
  Person kund;

  @Id @NonNull
  private String arendeNummer;

  @DBRef @Indexed(unique = true) @Singular
  List<Handling> handlings;

  private Status status;

  private Steg steg;
}
