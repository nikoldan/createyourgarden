package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;


public class Warenkorb {
    private double gesamtPreis = 0;
    private int anzahlArtikel = 0;
    private List<Artikel> korb = new ArrayList<>();
    @Id
    private String id;;
    private String kundenId;

    public Warenkorb() {
        
    }

    public void addArtikel(Artikel artikel) {
        this.korb.add(artikel);
        anzahlArtikel ++;
        gesamtPreis += 8;
    }

    public void entferneArtikel(Artikel artikel) {
        this.korb.remove(artikel);
        if (anzahlArtikel < 1) {
            anzahlArtikel --;
            gesamtPreis -= 8;
        }
    }

    public List<Artikel> getKorb() {
        return korb;
    }






}
