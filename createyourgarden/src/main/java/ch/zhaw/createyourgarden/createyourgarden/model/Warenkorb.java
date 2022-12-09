package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document("warenkorb")
public class Warenkorb {
    @Id
    private String id;

    private List<Warenkorb> korb = new ArrayList<>();

    public Warenkorb(List<Warenkorb> korb) {
        this.korb = korb;
    }

    
/*
    public Warenkorb(String kundenId, Double gesamtPreis, Double anzahlArtikel, List<Artikel> korb) {
        this.kundenId = kundenId;
        this.gesamtPreis = gesamtPreis;
        this.anzahlArtikel = anzahlArtikel;
        this.korb = korb;
    }

     
    public Warenkorb(List<Artikel> korb, String kundenId, double gesamtPreis, int anzahlArtikel) {
        this.korb = korb;
        this.kundenId = kundenId;
        this.gesamtPreis = gesamtPreis;
        this.anzahlArtikel = anzahlArtikel;
    }

    public Warenkorb(String kundenId, double gesamtPreis, int anzahlArtikel) {
        this.kundenId = kundenId;
        this.gesamtPreis = gesamtPreis;
        this.anzahlArtikel = anzahlArtikel;
    }
    

    public void addArtikel(Artikel artikel) {
        this.korb.add(artikel);
        anzahlArtikel++;
        gesamtPreis += 8;
    }

    public void entferneArtikel(Artikel artikel) {
        this.korb.remove(artikel);
        if (anzahlArtikel < 1) {
            anzahlArtikel--;
            gesamtPreis -= 8;
        }
    }


    public List<Artikel> getKorb() {
        return korb;
    }
*/
}
