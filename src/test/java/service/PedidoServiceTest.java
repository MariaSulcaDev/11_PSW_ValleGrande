package service;


import org.junit.jupiter.api.Test;
import vallegrande.edu.pe.service.PedidoService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoServiceTest {



        @Test
        public void testClienteVIP() {
            PedidoService service = new PedidoService();
            double total = service.calcularTotal(100, 2, "VIP");
            assertEquals(160, total);
        }

        @Test
        public void testClienteRegular() {
            PedidoService service = new PedidoService();
            double total = service.calcularTotal(100, 2, "REGULAR");
            assertEquals(180, total);
        }

        @Test
        public void testSinDescuento() {
            PedidoService service = new PedidoService();
            double total = service.calcularTotal(100, 2, "OTRO");
            assertEquals(200, total);
        }

        @Test
        public void testDescuentoAdicional() {
            PedidoService service = new PedidoService();
            double total = service.calcularTotal(100, 6, "REGULAR");
            assertEquals(520, total);
        }
    }