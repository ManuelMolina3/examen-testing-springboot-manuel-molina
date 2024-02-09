package com.salesianostriana.dam.testing.examen;

import com.salesianostriana.dam.testing.examen.model.DatoMeteorologico;
import com.salesianostriana.dam.testing.examen.model.DatoMeterologicoPK;
import com.salesianostriana.dam.testing.examen.repo.DatoMeteorologicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class RepositoryTestTemplate {

	/*
	 @Query("""
        select d from DatoMeteorologico d where lower(d.id.ciudad) = lower(?1)
    """)
    List<DatoMeteorologico> buscarPorPoblacion(String poblacion);
*/
	@Autowired
	DatoMeteorologicoRepository repository;

	@Container
	@ServiceConnection
	static PostgreSQLContainer postgres = new PostgreSQLContainer(DockerImageName.parse("postgres:16-alpine"))
			.withUsername("testUser")
			.withPassword("testSecret")
			.withDatabaseName("testDatabase");


	@Test
	void BuscarPorPoblacionTest() {
		DatoMeteorologico m1= new DatoMeteorologico(new DatoMeterologicoPK("almaden", LocalDate.of(1970, 1, 1)), 2.2);
		DatoMeteorologico m2= new DatoMeteorologico(new DatoMeterologicoPK("almaden", LocalDate.of(1970, 1, 1)), 2.2);
		DatoMeteorologico m3= new DatoMeteorologico(new DatoMeterologicoPK("almaden", LocalDate.of(1970, 1, 1)), 2.2);
		repository.saveAll(List.of(m1, m2, m3));
		List<DatoMeteorologico> encontrado= repository.buscarPorPoblacion("alamdén");
		List<DatoMeteorologico> noEncontrado= repository.buscarPorPoblacion("canarias");

		assertFalse(encontrado.isEmpty());
		assertTrue(noEncontrado.isEmpty());
	}


}
