package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BestellungCreateDTO {
    private String wunschDatum;
    private String vornameName;
    private double gesamtPreis;
    private List<Artikel> artikels;

}
