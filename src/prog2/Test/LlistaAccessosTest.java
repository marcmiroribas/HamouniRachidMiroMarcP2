package prog2.Test;

import org.junit.jupiter.api.Test;
import prog2.model.Acces;
import prog2.model.LlistaAccessos;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    @Test
    public void testAfegirAcces() {
        LlistaAccessos llistaAccessos = new LlistaAccessos();
        Acces acces = new CamiAsfaltat("A1", true, 200);
        llistaAccessos.afegirAcces(acces);
        assertEquals(1, llistaAccessos.getAccessos().size());
    }

    @Test
    public void testCalculaAccessosAccessibles() {
        LlistaAccessos llistaAccessos = new LlistaAccessos();
        Acces acces = new CamiAsfaltat("A1", true, 200);
        llistaAccessos.afegirAcces(acces);
        assertEquals(1, llistaAccessos.calculaAccessosAccessibles());
    }
}
