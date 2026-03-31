package vallegrande.edu.pe.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PedidoServiceTest {

    private final PedidoService service = new PedidoService();

    @Test
    public void testClienteVIP() {
        double total = service.calcularTotal(100, 2, "VIP");
        assertEquals(160, total);
    }

    @Test
    public void testClienteRegular() {
        double total = service.calcularTotal(100, 2, "REGULAR");
        assertEquals(180, total);
    }

    @Test
    public void testClienteRegularMinusculas() {
        double total = service.calcularTotal(100, 2, "regular");
        assertEquals(180, total);
    }

    @Test
    public void testSinDescuento() {
        double total = service.calcularTotal(100, 2, "OTRO");
        assertEquals(200, total);
    }

    @Test
    public void testTipoClienteNuloSeConsideraOtro() {
        double total = service.calcularTotal(100, 2, null);
        assertEquals(200, total);
    }

    @Test
    public void testTipoClienteVacioSeConsideraOtro() {
        double total = service.calcularTotal(100, 2, "   ");
        assertEquals(200, total);
    }

    @Test
    public void testTipoClienteDesconocidoSeConsideraOtro() {
        double total = service.calcularTotal(100, 2, "PREMIUM");
        assertEquals(200, total);
    }

    @Test
    public void testDescuentoAdicionalPorMontoMayorA500() {
        double total = service.calcularTotal(100, 6, "REGULAR");
        assertEquals(520, total);
    }

    @Test
    public void testSinDescuentoFijoCuandoTotalEs500Exactos() {
        double total = service.calcularTotal(100, 5, "OTRO");
        assertEquals(500, total);
    }

    @Test
    public void testPrecioNegativoLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularTotal(-1, 1, "VIP")
        );
        assertEquals("El precio no puede ser negativo", ex.getMessage());
    }

    @Test
    public void testCantidadCeroLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularTotal(100, 0, "VIP")
        );
        assertEquals("La cantidad debe ser mayor a cero", ex.getMessage());
    }

    @Test
    public void testCantidadNegativaLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularTotal(100, -2, "VIP")
        );
        assertEquals("La cantidad debe ser mayor a cero", ex.getMessage());
    }
}
