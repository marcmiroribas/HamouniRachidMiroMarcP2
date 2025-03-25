package prog2.model;

import prog2.model.Incidencia.TipusIncidencia;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies() {
        this.incidencies = new ArrayList<>();
    }

    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        // Comprovar si l'allotjament ja té una incidència
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una incidència registrada.");
            }
        }

        // Convertir String a TipusIncidencia
        TipusIncidencia tipusIncidencia;
        try {
            tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus d'incidència '" + tipus + "' no és vàlid.");
        }

        // Crear i afegir la nova incidència
        Incidencia novaIncidencia = new Incidencia(num, tipusIncidencia, allotjament, data);
        incidencies.add(novaIncidencia);

        // Tancar l'allotjament
        allotjament.tancarAllotjament(novaIncidencia);
    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        Iterator<Incidencia> iterator = incidencies.iterator();
        boolean trobat = false;

        while (iterator.hasNext()) {
            Incidencia i = iterator.next();
            if (i.equals(in)) {
                iterator.remove();
                // Obri l'allotjament associat
                i.getAllotjament().obrirAllotjament();
                trobat = true;
                break;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("No s'ha trobat la incidència a eliminar.");
        }
    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        if (incidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap incidència.");
        }

        StringBuilder resultat = new StringBuilder();
        for (Incidencia incidencia : incidencies) {
            resultat.append(incidencia.toString()).append("\n");
        }

        return resultat.toString();
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getNum() == num) {
                return incidencia;
            }
        }
        throw new ExcepcioCamping("No existeix cap incidència amb el número: " + num);
    }
}