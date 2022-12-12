package ch.zhaw.createyourgarden.createyourgarden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;



public class ArtikelTest {

@Test
public void testNewArtikel() {
    Artikel newArtikel = new Artikel("Artikelname", "deutscherName", "beschreibung");
    assertEquals("Artikelname", newArtikel.getName());
    assertNotEquals(newArtikel.getDName(), newArtikel.getName());

}

@Test
public void testNewArtikel2() {
    Artikel newArtikel = new Artikel("Artikelname", "deutscherName", "beschreibung");
    assertEquals("Artikelname", newArtikel.getName());
    assertNotEquals(newArtikel.getDName(), newArtikel.getName());
    newArtikel.setStandort("Sonnig");
    newArtikel.setBluetemonat(5);
    newArtikel.setHoehe(11);
    assertEquals("Sonnig", newArtikel.getStandort());
    assertEquals(5, newArtikel.getBluetemonat());
    assertEquals(11, newArtikel.getHoehe());
}

}
