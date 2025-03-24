package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies{
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
    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        // Comprovar si l’allotjament ja té una incidència (usant Iterator)
        Iterator<Incidencia> it = incidencies.iterator();
        while (it.hasNext()) {
            Incidencia incidencia = it.next();
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una incidència registrada.");
            }
        }

        // Validar el tipus d’incidència (enum)
        TipusIncidencia tipusIncidencia;
        try {
            tipusIncidencia = TipusIncidencia.valueOf(tipus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus d’incidència '" + tipus + "' no és vàlid.");
        }

        // Crear la incidència i afegir-la
        Incidencia novaIncidencia = new Incidencia(num, tipusIncidencia, allotjament, data);
        incidencies.add(novaIncidencia);

        // Tancar l’allotjament usant el teu mètode específic
        allotjament.tancarAllotjament(novaIncidencia);
    }


}
    /**
     * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param in Objecte de tipus Incidència
     * @throws ExcepcioCamping
     */
    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        boolean trobat = false;
        Iterator<Incidencia> iterator = incidencies.iterator();

        while (iterator.hasNext()) {
            Incidencia i = iterator.next();
            if (i.equals(in)) {
                iterator.remove();


    }
    /**
     * Itera sobre la llista d'incidències i retorna un String amb la informació de totes les incidències.
     * En cas que no hi hagi cap incidència llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        if (incidencies == null || incidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap incidència.");
        }

        StringBuilder resultat = new StringBuilder();
        Iterator<Incidencia> it = incidencies.iterator();

        while (it.hasNext()) {
            Incidencia incidencia = it.next();
            resultat.append(incidencia.toString()).append("\n");
        }

        return resultat.toString();
    }
    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        if (incidencies == null || incidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap incidència registrada.");
        }

        Iterator<Incidencia> it = incidencies.iterator();
        while (it.hasNext()) {
            Incidencia incidencia = it.next();
            if (incidencia.getNumero() == num) {
                return incidencia;
            }
        }

        throw new ExcepcioCamping("No existeix cap incidència amb el número: " + num);
    }

}
