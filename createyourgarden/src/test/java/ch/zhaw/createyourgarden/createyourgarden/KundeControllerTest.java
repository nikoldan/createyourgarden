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
@AutoConfigureMockMvc(addFilters = false)
public class KundeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateKunde() throws Exception {
        var result = mvc.perform(post("/api/kunde").content("{\"name\": \"TestName\",\"email\": \"TestEmail\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("\"name\":\"TestName\""));

    }

    @Test
    public void testGetAllKunde() throws Exception {
        var result = mvc.perform(get("/api/kunde")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"id\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("name"));
    }

    @Test
    public void testGetKundeById() throws Exception {
        var result = mvc.perform(get("/api/kunde/638f2c958a1eeb499c921628")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("\"name\":null"));
        assertTrue(result.getResponse().getContentAsString().contains("name"));
        assertTrue(result.getResponse().getContentAsString().contains("email"));
    }


}
