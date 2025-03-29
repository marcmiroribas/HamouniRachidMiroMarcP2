package prog2.model;

public class Allotjament implements InAllotjament {
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
        return temp == Temp.ALTA ? estadaMinimaAlta : estadaMinimaBaixa;
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
        switch(in.getTipusIncidencia()) {
            case Reparacio:
                this.illuminacio = 100;
                break;
            case Neteja:
                this.illuminacio = 50;
                break;
            case Tancament:
                this.illuminacio = 0;
                break;
        }
    }

    @Override
    public void obrirAllotjament() {
        this.operatiu = true;
        this.illuminacio = 100;
    }

    @Override
    public String toString() {
        return "Nom='" + nom + '\'' +
                ", Id='" + id + '\'' +
                ", Estada Mínima ALTA=" + estadaMinimaAlta +
                ", Estada Mínima BAIXA=" + estadaMinimaBaixa +
                ", Operatiu=" + (operatiu ? "Sí" : "No") +
                ", Il·luminació=" + illuminacio + "%";
    }
}
