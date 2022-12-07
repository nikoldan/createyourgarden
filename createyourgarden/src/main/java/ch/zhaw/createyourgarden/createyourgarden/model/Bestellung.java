package ch.zhaw.createyourgarden.createyourgarden.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document("bestellung")
public class Bestellung {
    @Id
    private String id;
    
    private String wunschDatum;
    private String vornameName;
    private List<Artikel> artikels;
    
    private BestellungState bestellungState = BestellungState.NEU;

    public Bestellung(String wunschDatum, String vornameName, List<Artikel> artikels) {
        this.wunschDatum = wunschDatum;
        this.vornameName = vornameName;
        this.artikels = artikels;
    }



}
