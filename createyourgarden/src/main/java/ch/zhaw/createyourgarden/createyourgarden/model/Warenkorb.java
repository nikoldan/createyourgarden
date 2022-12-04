package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Document("warenkorb")
public class Warenkorb {
    @Id
    private String id;
    @NonNull
    private List<Artikel> korb = new ArrayList<>();
    @NonNull
    private String kundenId;

    private double gesamtPreis = 0;

    private int anzahlArtikel = 0;

    public Warenkorb(List<Artikel> korb2, String kundenId2, double gesamtPreis2, int anzahlArtikel2) {
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

}
