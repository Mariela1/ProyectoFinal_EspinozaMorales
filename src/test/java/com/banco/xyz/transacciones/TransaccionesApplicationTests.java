package com.banco.xyz.transacciones;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.repository.TransaccionRepository;
import com.banco.xyz.transacciones.service.TransaccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransaccionesApplicationTests {

	@Mock
	private TransaccionRepository transaccionRepository;

	@InjectMocks
	private TransaccionService transaccionService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
		// Verifica que el servicio de transacciones se cargue en el contexto
		assertNotNull(transaccionService, "El servicio de transacciones no debe ser nulo");
	}

	@Test
	void testRegistrarYObtenerTransaccion() {
		// Crear una transacción simulada
		String id = "12345";
		String tipo = "transferencia"; // Asegúrate de definir un tipo
		Double monto = 100.0;
		String cuentaOrigen = "CUENTA_ORIGEN";
		String cuentaDestino = "CUENTA_DESTINO";

		// Asegúrate de usar el constructor adecuado
		Transaccion nuevaTransaccion = new Transaccion(id, tipo, monto, cuentaOrigen, cuentaDestino);

		// Simulamos que el repositorio devuelve la transacción
		when(transaccionRepository.findById(id)).thenReturn(Mono.just(nuevaTransaccion));

		// Act: Obtenemos la transacción a través del servicio
		Transaccion transaccionObtenida = transaccionService.obtenerTransaccionPorId(id).block();  // .block() bloquea la operación reactiva y obtiene el resultado

		// Assert: verificar que la transacción obtenida es correcta
		assertNotNull(transaccionObtenida, "La transacción obtenida no debe ser nula");
		assertEquals(id, transaccionObtenida.getId(), "El ID debe coincidir");
		assertEquals(monto, transaccionObtenida.getMonto(), 0.01, "El monto debe coincidir");
	}
}
