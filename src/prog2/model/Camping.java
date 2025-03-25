package model;

import java.util.HashMap;
import java.util.Map;
import prog2.model.LlistaIncidencies;
import prog2.model.Acces;
import prog2.model.Allotjament;
import prog2.model.Incidencia;
import prog2.model.LlistaAccessos;
import prog2.vista.ExcepcioCamping;



public class Camping {
    private Map<String, Allotjament> allotjaments;
    private LlistaIncidencies llistaIncidencies;
    private LlistaAccessos llistaAccessos;

    public Camping() {
        this.allotjaments = new HashMap<>();
        this.llistaIncidencies = new LlistaIncidencies();
        this.llistaAccessos = new LlistaAccessos();
        inicialitzaDadesCamping();
    }

    private void inicialitzaDadesCamping() {
            inicialitzaDadesCamping();
    }

    public void afegirIncidencia(int numIncidencia, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        Allotjament allotjament = allotjaments.get(idAllotjament);
        if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament amb ID " + idAllotjament + " no existeix.");
        }

        llistaIncidencies.afegirIncidencia(numIncidencia, tipus, allotjament, data);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public void eliminarIncidencia(int numIncidencia) throws ExcepcioCamping {
        Incidencia incidencia = llistaIncidencies.getIncidencia(numIncidencia);
        if (incidencia == null) {
            throw new ExcepcioCamping("No s'ha trobat la incidència amb número " + numIncidencia + ".");
        }

        llistaIncidencies.eliminarIncidencia(numIncidencia);
        llistaAccessos.actualitzaEstatAccessos();
    }
}
