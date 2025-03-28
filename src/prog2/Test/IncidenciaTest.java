package prog2.Test;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Incidencia;

import static org.junit.jupiter.api.Assertions.*;

public class IncidenciaTest {

    @Test
    public void testConstructor() {
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        Incidencia incidencia = new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, allotjament, "2025-03-28");

        assertEquals(1, incidencia.getNum());  // Verificamos el número de incidencia.
        assertEquals("ALL1", incidencia.getAllotjament().getId());  // Comprobamos que el allotjament es el correcto.
        assertEquals("2025-03-28", incidencia.getData());  // Comprobamos la fecha.
        assertEquals(Incidencia.TipusIncidencia.Reparacio, incidencia.getTipusIncidencia());  // Comprobamos el tipo de incidencia.
    }

    @Test
    public void testSetters() {
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        Incidencia incidencia = new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, allotjament, "2025-03-28");

        incidencia.setNum(2);
        incidencia.setAllotjament(new Allotjament("ALL2", "Parcel·la Sud", false));
        incidencia.setData("2025-03-29");
        incidencia.setTipusIncidencia(Incidencia.TipusIncidencia.Neteja);

        assertEquals(2, incidencia.getNum());  // Verificamos el número de incidencia.
        assertEquals("ALL2", incidencia.getAllotjament().getId());  // Comprobamos que el allotjament se ha actualizado correctamente.
        assertEquals("2025-03-29", incidencia.getData());  // Comprobamos que la fecha se ha actualizado correctamente.
        assertEquals(Incidencia.TipusIncidencia.Neteja, incidencia.getTipusIncidencia());  // Comprobamos que el tipo de incidencia se ha actualizado.
    }

    @Test
    public void testToString() {
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        Incidencia incidencia = new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, allotjament, "2025-03-28");

        String expected = "Incidència núm: 1, Data: 2025-03-28, Tipus: Reparacio, Allotjament: [ALL1 - Parcel·la Nord - Actiu]";
        assertEquals(expected, incidencia.toString());  // Comprobamos que el método toString devuelve la cadena esperada.
    }

    @Test
    public void testGetIluminacioAllotjament() {
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);

        Incidencia incidenciaReparacio = new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, allotjament, "2025-03-28");
        assertEquals("S'ha de deixar una iluminació del 100%", incidenciaReparacio.getIluminacioAllotjament());  // Comprobamos iluminación para reparaciones.

        Incidencia incidenciaNeteja = new Incidencia(2, Incidencia.TipusIncidencia.Neteja, allotjament, "2025-03-29");
        assertEquals("S'ha de deixar una iluminació del 50%", incidenciaNeteja.getIluminacioAllotjament());  // Comprobamos iluminación para limpieza.

        Incidencia incidenciaTancament = new Incidencia(3, Incidencia.TipusIncidencia.Tancament, allotjament, "2025-03-30");
        assertEquals("S'ha de deixar una iluminació del 0%", incidenciaTancament.getIluminacioAllotjament());  // Comprobamos iluminación para cierre.
    }
}
