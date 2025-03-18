package model;

import prog2.model.InAllotjament;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;
    private boolean operatiu;
    private int illuminacio;

    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
        this.operatiu = true;
        this.illuminacio = 100;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaMinimaAlta : estadaMinimaBaixa;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
    }

    public boolean isOperatiu() {
        return operatiu;
    }

    public int getIlluminacio() {
        return illuminacio;
    }

    @Override
    public void tancarAllotjament(Incidencia in) {
        this.operatiu = false;
        this.illuminacio = in.afectaIluminacio() ? 0 : illuminacio;
    }

    @Override
    public void obrirAllotjament() {
        this.operatiu = true;
        this.illuminacio = 100;
    }

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", Estada mínima en temp ALTA: " + estadaMinimaAlta +
                ", Estada mínima en temp BAIXA: " + estadaMinimaBaixa +
                ", Operatiu: " + operatiu + ", Il·luminació: " + illuminacio + "%";
    }
}
