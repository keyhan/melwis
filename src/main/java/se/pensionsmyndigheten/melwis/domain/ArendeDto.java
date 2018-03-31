package se.pensionsmyndigheten.melwis.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "personNummer")
public class ArendeDto {
    private String personNummer;
    private HandlingDto handlingar;
}
