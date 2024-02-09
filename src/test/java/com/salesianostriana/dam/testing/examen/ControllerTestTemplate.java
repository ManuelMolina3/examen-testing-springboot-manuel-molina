package com.salesianostriana.dam.testing.examen;


import com.salesianostriana.dam.testing.examen.dto.GetMediaFechaPoblacionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTestTemplate {

    /*
    @GetMapping("/media/mes/{ciudad}")
    public GetMediaFechaPoblacionDto mediaMensualPorPoblacion(@PathVariable String ciudad) {
        return GetMediaFechaPoblacionDto.of(ciudad, servicio.mediaMensual(ciudad));
    }*/
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private GetMediaFechaPoblacionDto meteologiaDto;


    @Test
    void GetMediaFechaPorPoblacionDTO_ThenReturn200() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(("/meteo/media/mes/{ciudad}"), meteologiaDto.ciudad())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
