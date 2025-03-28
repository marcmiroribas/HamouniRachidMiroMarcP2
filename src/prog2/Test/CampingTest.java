package prog2.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.Camping;
import prog2.vista.ExcepcioCamping;

public class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping();  // Es crea una nova instància abans de cada test
    }

    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Electrica", "ALL3", "2025-03-25");
        String result = camping.llistarIncidencies();
        assertTrue(result.contains("Electrica"), "L'incidència hauria d'estar registrada.");
    }

    @Test
    void testEliminarIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(2, "Aigua", "ALL3", "2025-03-25");
        camping.eliminarIncidencia(2);
        String result = camping.llistarIncidencies();
        assertFalse(result.contains("Aigua"), "L'incidència hauria d'haver estat eliminada.");
    }

    @Test
    void testGuardarICarregar() throws ExcepcioCamping {
        String path = "testCamping.dat";
        camping.afegirIncidencia(3, "Seguretat", "ALL3", "2025-03-25");
        camping.save(path);

        Camping loadedCamping = Camping.load(path);
        String result = loadedCamping.llistarIncidencies();
        assertTrue(result.contains("Seguretat"), "L'incidència hauria d'haver estat carregada correctament.");
    }
}
