package vallegrande.edu.pe.service;

public class PedidoService {

    private static final double DESCUENTO_VIP = 0.20;
    private static final double DESCUENTO_REGULAR = 0.10;
    private static final double UMBRAL_DESCUENTO_FIJO = 500.0;
    private static final double DESCUENTO_FIJO = 20.0;

    public double calcularTotal(double precio, int cantidad, String tipoCliente) {
        validarEntrada(precio, cantidad);

        TipoCliente tipo = TipoCliente.from(tipoCliente);
        double subtotal = calcularSubtotal(precio, cantidad);
        double totalConDescuentoCliente = aplicarDescuentoPorCliente(subtotal, tipo);

        return aplicarDescuentoFijo(totalConDescuentoCliente);
    }

    private void validarEntrada(double precio, int cantidad) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
    }

    private double calcularSubtotal(double precio, int cantidad) {
        return precio * cantidad;
    }

    private double aplicarDescuentoPorCliente(double total, TipoCliente tipoCliente) {
        return switch (tipoCliente) {
            case VIP -> total - (total * DESCUENTO_VIP);
            case REGULAR -> total - (total * DESCUENTO_REGULAR);
            case OTRO -> total;
        };
    }

    private double aplicarDescuentoFijo(double total) {
        if (total > UMBRAL_DESCUENTO_FIJO) {
            return total - DESCUENTO_FIJO;
        }
        return total;
    }
}
