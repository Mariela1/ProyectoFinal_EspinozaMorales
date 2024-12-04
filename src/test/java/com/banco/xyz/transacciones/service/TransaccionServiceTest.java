package com.banco.xyz.transacciones.service;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.repository.TransaccionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransaccionServiceTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @InjectMocks
    private TransaccionService transaccionService;

    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        // Inicializamos una transacción de prueba
        transaccion = new Transaccion("1", "TRANSFERENCIA", 500.0, "12345", "67890");
    }

    @Test
    public void testGuardarTransaccion() {
        // Arrange
        when(transaccionRepository.save(any(Transaccion.class))).thenReturn(Mono.just(transaccion));

        // Act
        Transaccion resultado = transaccionService.guardarTransaccion(transaccion).block();

        // Assert
        assertNotNull(resultado);
        assertEquals("1", resultado.getId());
        assertEquals("TRANSFERENCIA", resultado.getTipo());
        assertEquals(500.0, resultado.getMonto());
        verify(transaccionRepository, times(1)).save(transaccion); // Verificamos que save fue llamado una vez
    }

    @Test
    public void testObtenerTransaccionPorId() {
        // Arrange
        String id = "12345";
        String tipo = "transferencia";  // Asumimos un tipo de transacción
        Double monto = 100.0;
        String cuentaOrigen = "CUENTA_ORIGEN";
        String cuentaDestino = "CUENTA_DESTINO";
        Transaccion transaccionEsperada = new Transaccion(id, tipo, monto, cuentaOrigen, cuentaDestino); // Crea un objeto de transacción con id
        when(transaccionRepository.findById(id)).thenReturn(Mono.just(transaccionEsperada)); // Mock de repositorio

        // Act
        Transaccion transaccionObtenida = transaccionService.obtenerTransaccionPorId(id).block();

        // Assert
        assertNotNull(transaccionObtenida); // Verifica que la transacción no sea nula
        assertEquals(id, transaccionObtenida.getId()); // Verifica que el id coincida
        assertEquals(100.0, transaccionObtenida.getMonto(), 0.01); // Verifica que el monto coincida (si es relevante)
    }




    @Test
    public void testEliminarTransaccion() {
        // Act
        transaccionService.eliminarTransaccion("1");

        // Assert
        verify(transaccionRepository, times(1)).deleteById("1");
    }



}
