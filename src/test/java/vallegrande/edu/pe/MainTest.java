package vallegrande.edu.pe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testMainImprimeMensajeYSecuencia() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        String contenido = output.toString(StandardCharsets.UTF_8);
        assertTrue(contenido.contains("Hello and welcome!"));
        assertTrue(contenido.contains("i = 1"));
        assertTrue(contenido.contains("i = 5"));
    }
}
