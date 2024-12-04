package com.banco.xyz.transacciones;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.service.TransaccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransaccionesApplicationTests {

	@Autowired
	private TransaccionService transaccionService;

	@Test
	void contextLoads() {
		// Verifica que el servicio de transacciones se cargue en el contexto
		assertNotNull(transaccionService, "El servicio de transacciones no debe ser nulo");
	}

	@Test
	void testRegistrarYObtenerTransaccion() {
		// Crear una transacción simulada
		Transaccion nuevaTransaccion = new Transaccion();
		nuevaTransaccion.setTipo("DEPOSITO");
		nuevaTransaccion.setMonto(200.0);
		nuevaTransaccion.setCuentaOrigen("11111");
		nuevaTransaccion.setCuentaDestino("22222");

		// Guardar la transacción
		Mono<Transaccion> transaccionGuardadaMono = transaccionService.registrarTransaccion(nuevaTransaccion);

		// Verificar que se haya guardado correctamente
		Transaccion transaccionGuardada = transaccionGuardadaMono.block();
		assertNotNull(transaccionGuardada, "La transacción guardada no debe ser nula");
		assertNotNull(transaccionGuardada.getId(), "El ID de la transacción no debe ser nulo después de guardarla");

		// Probar obtenerPorId usando el ID de la transacción guardada
		String id = transaccionGuardada.getId();
		Mono<Transaccion> transaccionObtenidaMono = transaccionService.obtenerPorId(id);
		Transaccion transaccionObtenida = transaccionObtenidaMono.block();

		assertNotNull(transaccionObtenida, "La transacción obtenida no debe ser nula");
		assertEquals(id, transaccionObtenida.getId(), "El ID de la transacción obtenida debe coincidir con el esperado");
	}
}
