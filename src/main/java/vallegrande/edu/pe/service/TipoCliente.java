package vallegrande.edu.pe.service;

import java.util.Locale;

public enum TipoCliente {
    VIP,
    REGULAR,
    OTRO;

    public static TipoCliente from(String valor) {
        if (valor == null || valor.isBlank()) {
            return OTRO;
        }

        try {
            return TipoCliente.valueOf(valor.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            return OTRO;
        }
    }
}
