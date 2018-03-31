package se.pensionsmyndigheten.melwis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "Persons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @Indexed(unique = true)
  private String personNummer;

  @Id @NonNull
  private String kundNummer;

  private LocalDate dob;

  private String firstName;

  private List<String> middleNames;

  private String lastName;

  @DBRef List<Person> efterlevande;

  @DBRef @Indexed(unique = true) Person partner;

  Civilstand civilstand;
}
