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
    public void afegirIncidencia(int num, String tipus, model.Allotjament allotjament, String data) throws ExcepcioCamping { // Falta excepcions
        Incidencia novaIncidencia = new Incidencia(num, tipus, allotjament, data);
        incidencies.add(novaIncidencia);

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
}
