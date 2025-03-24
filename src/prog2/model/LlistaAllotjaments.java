package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjament implements InLlistaAllotjaments {
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjament() {
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament no pot ser null");
        }
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder resultat = new StringBuilder();
        Iterator<Allotjament> it = allotjaments.iterator();
        boolean trobat = false;

        while (it.hasNext()) {
            Allotjament a = it.next();
            String estatAllotjament = a.isOperatiu() ? "Operatiu" : "No operatiu";
            if (estatAllotjament.equalsIgnoreCase(estat)) {
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
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            if (it.next().isOperatiu()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            if (it.next().equals(allotjament)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String nom) throws ExcepcioCamping {
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            Allotjament a = it.next();
            if (a.getNom().equalsIgnoreCase(nom)) {
                return a;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat cap allotjament amb el nom: " + nom);
    }
}