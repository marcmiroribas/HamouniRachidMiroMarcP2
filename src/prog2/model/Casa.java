package prog2.model;

public class Casa extends Allotjament {
    private boolean piscina;
    private boolean jardi;

    public Casa(String nom, String idAllotjament, int estadaMinimaAlta,
                int estadaMinimaBaixa, boolean piscina, boolean jardi) {
        super(nom, idAllotjament, estadaMinimaAlta, estadaMinimaBaixa);
        this.piscina = piscina;
        this.jardi = jardi;
    }

    // Getters específicos
    public boolean tePiscina() {
        return piscina;
    }

    public boolean teJardi() {
        return jardi;
    }

    public boolean correcteFuncionament() {
        return isOperatiu();
    }

    @Override
    public String toString() {
        return "Casa [" + super.toString() +
                ", piscina=" + (piscina ? "Sí" : "No") +
                ", jardi=" + (jardi ? "Sí" : "No") + "]";
    }
}