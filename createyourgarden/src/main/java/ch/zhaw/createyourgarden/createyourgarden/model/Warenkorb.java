package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.ArrayList;
import java.util.List;


public class Warenkorb {
    private double gesamtPreis = 0;
    private int anzahlArtikel = 0;
    private List<Artikel> korb = new ArrayList<>();

    public Warenkorb() {
        
    }

    public void addArtikel(Artikel artikel) {
        this.korb.add(artikel);
        anzahlArtikel ++;
    }

    public void entferneArtikel(Artikel artikel) {
        this.korb.remove(artikel);
        if (anzahlArtikel < 1) {
            anzahlArtikel --;
        }
    }

    public List<Artikel> getKorb() {
        return korb;
    }





}
