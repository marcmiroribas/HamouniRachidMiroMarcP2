package prog2.model;

public class Casa extends Allotjament {
    private boolean piscina;
    private boolean jardi;

    public Casa(String nom, String idAllotjament,boolean operatiu, String iluminacio, int estadaMinimaAlta,
                int estadaMinimaBaixa, boolean piscina, boolean jardi) {
        super(nom, idAllotjament, estadaMinimaAlta, estadaMinimaBaixa,operatiu, iluminacio);
        this.piscina = piscina;
        this.jardi = jardi;
    }


    public boolean tePiscina() {
        return piscina;
    }

    public boolean teJardi() {
        return jardi;
    }
    @Override
    public boolean isOperatiu() {
        return true;
    }

    @Override
    public String toString() {
        return "Casa [" + super.toString() +
                ", piscina=" + (piscina ? "Sí" : "No") +
                ", jardi=" + (jardi ? "Sí" : "No") + "]";
    }
}