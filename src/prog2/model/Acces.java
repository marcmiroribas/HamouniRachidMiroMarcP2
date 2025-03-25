package prog2.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Acces implements InAcces {
    protected List<Allotjament> allotjaments;
    protected String nom;
    protected boolean accessibilitat;
    protected boolean estat;

    public Acces(String nom, boolean accessibilitat, boolean estat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        allotjaments.add(allotjament);
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }
}
