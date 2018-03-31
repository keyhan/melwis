package se.pensionsmyndigheten.melwis.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@ToString(exclude = {"personNummer","partnerPersonNummer","efterlevande"})
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private String personNummer;

    private LocalDate dob;

    private String firstName;

    private List<String> middleNames;

    private String lastName;

    List<String> efterlevande;

    private String partnerPersonNummer;

    Civilstand civilstand;
}
