package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WarenkorbDTO {
    private List<Artikel> korb;
    private String kundenId;
    private double gesamtPreis;
    private int anzahlArtikel;
    
}
