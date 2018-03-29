package se.pensionsmyndigheten.melwis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "Handling")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Handling {
  @Id
  private long id;

  @Indexed(unique = true)
  @NonNull
  private String handlingsNummer;

  private Map<String, Byte[]> attachements;
}
