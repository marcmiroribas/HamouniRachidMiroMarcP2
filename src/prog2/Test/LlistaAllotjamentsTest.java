package prog2.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LlistaAllotjamentsTest {

    @Test
    public void testAfegirAllotjament() {
        LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        llistaAllotjaments.afegirAllotjament(allotjament);
        assertEquals(1, llistaAllotjaments.getAllotjaments().size());
    }

    @Test
    public void testGetAllotjamentById() {
        LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();
        Allotjament allotjament = new Allotjament("ALL1", "Parcel·la Nord", true);
        llistaAllotjaments.afegirAllotjament(allotjament);
        Allotjament result = llistaAllotjaments.getAllotjamentById("ALL1");
        assertNotNull(result);
        assertEquals("ALL1", result.getId());
    }
}
