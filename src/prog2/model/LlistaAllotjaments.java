package prog2.model;

import model.Allotjament;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjament implements InLlistaAllotjaments {
    private ArrayList<model.Allotjament> allotjaments;


    public LlistaAllotjament() {
        this.allotjaments = new ArrayList<>();
    }
    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     * @param allotjament Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */

    @Override
    public void afegirAllotjament(model.Allotjament allotjament) throws ExcepcioCamping {
        allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        allotjaments.clear();
    }
    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     * @param estat
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder resultat = new StringBuilder();
        Iterator<model.Allotjament> iterator = allotjaments.iterator();
        boolean trobat = false;

        while (iterator.hasNext()) {
            model.Allotjament a = iterator.next();
            if (a.getEstat().equalsIgnoreCase(estat)) {
                resultat.append(a.toString()).append("\n");
                trobat = true;
            }
        }
        if (!trobat) {
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat: " + estat);
        }

        return resultat.toString();

    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {

    }
}