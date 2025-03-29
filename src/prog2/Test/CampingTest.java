/*
package prog2.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import prog2.model.Bungalow;
import prog2.model.Camping;
import prog2.vista.ExcepcioCamping;

public class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() {
        try {
            Str
            camping = new Camping(nom);  // Es crea una nova instància abans de cada test
            String nom = "Bungalow Nord";
            String idAllotjament = "ALL3";
            float mida = 22f;
            int habitacions = 2;
            int placesPersones = 4;
            int placesParquing = 1;
            boolean terrassa = true;
            boolean tv = true;
            boolean aireFred = true;

            Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            camping.getLlistaAllotjaments().afegirAllotjament(ALL3);
        } catch (ExcepcioCamping e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        camping.afegirIncidencia(1, "Neteja", "ALL3", "2025-03-25");
        String result = camping.llistarIncidencies();
        assertTrue(result.contains("Neteja"), "L'incidència hauria d'estar registrada.");
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
}*/
