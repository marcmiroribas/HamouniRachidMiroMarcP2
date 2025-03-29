package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.List;

public abstract class Acces implements InAcces {
    protected LlistaAllotjaments allotjaments;
    protected String nom;
    protected boolean accessibilitat;
    protected boolean estat;

    public Acces(String nom, boolean accessibilitat, boolean estat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.allotjaments = new LlistaAllotjaments();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament)throws ExcepcioCamping {
        allotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }
    public boolean isEmpty(){
        return allotjaments.isEmpty();
    }
}
