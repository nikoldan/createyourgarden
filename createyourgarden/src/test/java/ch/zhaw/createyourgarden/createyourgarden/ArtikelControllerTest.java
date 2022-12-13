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
@AutoConfigureMockMvc(addFilters = false) // User Token
public class ArtikelControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAllArtikel() throws Exception {
        var result = mvc.perform(get("/api/artikel")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"totalElements\":0"));
        assertTrue(result.getResponse().getContentAsString().contains("standort"));
    }
    
    @Test
    public void testGetArtikelById() throws Exception {
        var result = mvc.perform(get("/api/artikel/6396fbe239ed3e2a81b02743")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"name\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("standort"));
    }

    @Test
    public void testGetArtikelByStandort() throws Exception {
        var result = mvc.perform(get("/api/artikel?wo=Sonnig")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"name\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("name"));
        assertTrue(result.getResponse().getContentAsString().contains("\"standort\":\"Sonnig"));
    }

}
