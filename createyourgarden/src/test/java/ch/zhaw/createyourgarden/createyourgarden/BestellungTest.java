package ch.zhaw.createyourgarden.createyourgarden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;

public class BestellungTest {

    @Test
    public void testNewBestellung() {
        Bestellung newBestellung = new Bestellung("25.12.2022", "Daniel Nikolic", 32, null);
        assertEquals("25.12.2022", newBestellung.getWunschDatum());
        assertNotEquals(newBestellung.getVornameName(), newBestellung.getWunschDatum());

    }
 

}
