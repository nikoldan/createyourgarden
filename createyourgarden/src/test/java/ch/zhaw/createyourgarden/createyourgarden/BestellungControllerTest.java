package ch.zhaw.createyourgarden.createyourgarden;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // für Authentication
public class BestellungControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateBestellung() throws Exception {
        var result = mvc.perform(post("/api/bestellung").content("{\"wunschDatum\": \"29.11.9999\",\"vornameName\": \"TestName\",\"gesamtPreis\": 18,\"artikels\": [{\"id\": \"455555\",\"name\": \"artikelname\",\"dName\": \"deutscherName..\",\"beschreibung\": \"besekjk\",\"standort\": \"sanndndn\",\"bluetemonat\": 5,\"hoehe\": 33}]}")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isCreated())
        .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("\"wunschDatum\":\"29.11.9999\""));
    }

    @Test
    public void testGetBestellungById() throws Exception {
        var result = mvc.perform(get("/api/bestellung/639892ed7a1af568fe5d651b")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"name\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("bestellungState"));
    }

    @Test
    public void testGetBestellungByState() throws Exception {
        var result = mvc.perform(get("/api/bestellung/bystate")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"id\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("bestellIds"));
        assertTrue(result.getResponse().getContentAsString().contains("\"id\":\"NEU"));
    }



}
