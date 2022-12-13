package ch.zhaw.createyourgarden.createyourgarden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;

public class KundeTest {
    
    @Test
    public void testNewKunde() {
        Kunde newKunde = new Kunde("testName", "testEmail");
        assertEquals("testName", newKunde.getName());
        assertNotEquals(newKunde.getName(), newKunde.getEmail());
    }
}
