package ch.zhaw.createyourgarden.createyourgarden.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WarenkorbDTO {
    private String kundenId;
    private double gesamtPreis;
    private int anzahlArtikel;
   //   private List<Artikel> korb; 
}
