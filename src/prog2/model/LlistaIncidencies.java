package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import prog2.model.Incidencia.TipusIncidencia;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies() {
        this.incidencies = new ArrayList<>();
    }

    /**
     * Aquest mètode crea una incidència amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït i la data) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una incidència si ja té una incidència s'ha de llançar una excepció.
     * Una vegada creada la incidència s'ha de tancar (no operatiu) l'allotjament corresponent.
     * @param num Número d'identificació de la incidència.
     * @param tipus Aquest String permet crear el enum TipusIncidencia
     * @param allotjament Allotjament on es produeix la incidència
     * @param data Data quan es produeix la incidència.
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una incidència o si el tipus d’incidència que es vol afegir no existeix.
     */
    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        for (Incidencia i : incidencies) {
            if (i.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament ja té una incidència registrada.");
            }
        }

        TipusIncidencia tipusInc;
        try {
            tipusInc = TipusIncidencia.valueOf(tipus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus d'incidència no és vàlid.");
        }

        Incidencia novaIncidencia = new Incidencia(num, tipusInc, allotjament, data);
        incidencies.add(novaIncidencia);
        allotjament.tancarAllotjament();
    }

    /**
     * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param in Objecte de tipus Incidència
     * @throws ExcepcioCamping
     */
    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        if (!incidencies.remove(in)) {
            throw new ExcepcioCamping("No s'ha trobat la incidència per eliminar.");
        }
        in.getAllotjament().obrirAllotjament();
    }

    /**
     * Itera sobre la llista d'incidències i retorna un String amb la informació de totes les incidències.
     * En cas que no hi hagi cap incidència llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        if (incidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha incidències registrades.");
        }

        StringBuilder resultat = new StringBuilder();
        for (Incidencia i : incidencies) {
            resultat.append(i.toString()).append("\n");
        }
        return resultat.toString();
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia i : incidencies) {
            if (i.getNum() == num) {
                return i;
            }
        }
        throw new ExcepcioCamping("No existeix cap incidència amb el número indicat.");
    }
}
