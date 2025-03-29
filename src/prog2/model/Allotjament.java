package prog2.model;

public class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;
    private boolean operatiu;
    private String iluminacio;

    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa, boolean operatiu, String iluminacio) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
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

    public String getIluminacio() {
        return iluminacio;
    }

    @Override
    public void tancarAllotjament(Incidencia in) {
        this.operatiu = false;
        switch(in.getTipusIncidencia()) {
            case Reparacio:
                this.iluminacio = "100";
                break;
            case Neteja:
                this.iluminacio = "50";
                break;
            case Tancament
                    :
                this.iluminacio = "0";
                break;
        }
    }

    @Override
    public void obrirAllotjament() {
        this.operatiu = true;
        this.iluminacio = "100";
    }

    @Override
    public String toString() {
        return "Nom='" + nom + '\'' +
                ", Id='" + id + '\'' +
                ", Estada Mínima ALTA=" + estadaMinimaAlta +
                ", Estada Mínima BAIXA=" + estadaMinimaBaixa +
                ", Operatiu=" + (operatiu ? "Sí" : "No") +
                ", Il·luminació=" + iluminacio + "%";
    }

    @Override
    public int hashCode() {
        return id.hashCode(); // Coherencia con equals()
    }
}
