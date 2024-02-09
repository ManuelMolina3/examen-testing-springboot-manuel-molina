package com.salesianostriana.dam.testing.examen;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class ControllerTestTemplate {

    /*
    @GetMapping("/media/mes/{ciudad}")
    public GetMediaFechaPoblacionDto mediaMensualPorPoblacion(@PathVariable String ciudad) {
        return GetMediaFechaPoblacionDto.of(ciudad, servicio.mediaMensual(ciudad));
    }*/
    @Autowired
    private MockMvc mvc;



    @Test
    void GetMediaFechaPorPoblacionDTO_ThenReturn200() throws Exception{

    }
}
