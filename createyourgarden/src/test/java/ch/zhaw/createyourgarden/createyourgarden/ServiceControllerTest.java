package ch.zhaw.createyourgarden.createyourgarden;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // für Authentication
public class ServiceControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void testBestellBestaetigung() throws Exception {
        var result = mvc.perform(post("/api/service/bBestaetigung").content("{\"bestellungId\": \"639892ed7a1af568fe5d651b\"}")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("\"bestellungState\":\"BESTAETIGT\""));
    }

    @Test
    public void testBestellBereitgestellt() throws Exception {
        var result = mvc.perform(post("/api/service/bBereitgestellt").content("{\"bestellungId\": \"639892ed7a1af568fe5d651b\"}")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("\"bestellungState\":\"BEREITGESTELLT\""));
    }


}
