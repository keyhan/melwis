package se.pensionsmyndigheten.melwis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Arende")
@Data
@Builder
@ToString(exclude = {"personNummer", "handlingsNummers"})
@AllArgsConstructor
@NoArgsConstructor
public class Arende {
  @Id
  private long id;

  @DBRef
  Person person;

  @Indexed(unique = true)
  private String arendeNummer;

  @DBRef
  List<Handling> handlings;

  @Transient
  private String personNummer;

  @Transient
  private List<String> handlingsNummers;
}
