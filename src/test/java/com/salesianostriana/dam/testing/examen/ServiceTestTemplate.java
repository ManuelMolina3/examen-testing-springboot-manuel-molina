package com.salesianostriana.dam.testing.examen;

import com.salesianostriana.dam.testing.examen.repo.DatoMeteorologicoRepository;
import com.salesianostriana.dam.testing.examen.service.ServicioMeteorologico;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTestTemplate {



    /*    public Map<String, Double> mediaDiaSemana(String poblacion) {
        List<DatoMeteorologico> filtrados =
                repository.buscarPorPoblacion(poblacion);

        Map<String, List<Double>> aux = new HashMap<>();
        Map<String, Double> result = new HashMap<>();

        for(DatoMeteorologico dato : filtrados) {
            if (!aux.containsKey(fechaADiaSemana(dato.getId().getFecha()))) {
                aux.put(fechaADiaSemana(dato.getId().getFecha()), new ArrayList<>());
                aux.get(fechaADiaSemana(dato.getId().getFecha())).add(dato.getPrecipitacion());
            } else {
                aux.get(fechaADiaSemana(dato.getId().getFecha())).add(dato.getPrecipitacion());
            }
        }

        for (String diaSemana : aux.keySet()) {
            double acumulador = 0;
            for (double precipitacion : aux.get(diaSemana)) {
                acumulador += precipitacion;
            }
            double media = acumulador / aux.get(diaSemana).size();
            result.put(diaSemana, media);
        }


        return result;
    }*/

    @Mock
    ServicioMeteorologico service;

    @InjectMocks
    DatoMeteorologicoRepository repository;






}
