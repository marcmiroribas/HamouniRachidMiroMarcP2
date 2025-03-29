/*
package prog2.Test;

import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Incidencia;
import prog2.model.LlistaIncidencies;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaIncidenciesTest {

    @Test
    public void testAfegirIncidencia() {
        LlistaIncidencies llistaIncidencies = new LlistaIncidencies();
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        Incidencia incidencia = new Incidencia(1, "Incidència tipus 1", allotjament, "2025-03-28");
        llistaIncidencies.afegirIncidencia(incidencia);
        assertEquals(1, llistaIncidencies.getIncidencies().size());
    }

    @Test
    public void testEliminarIncidencia() {
        LlistaIncidencies llistaIncidencies = new LlistaIncidencies();
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        Incidencia incidencia = new Incidencia(1, "Incidència tipus 1", allotjament, "2025-03-28");
        llistaIncidencies.afegirIncidencia(incidencia);
        llistaIncidencies.eliminarIncidencia(incidencia);
        assertEquals(0, llistaIncidencies.getIncidencies().size());
    }
}
*/