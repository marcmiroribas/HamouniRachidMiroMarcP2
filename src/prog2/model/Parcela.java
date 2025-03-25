package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, float mida, boolean connexioElectrica) {
        super(nom, idAllotjament, 4, 2); // Estada mínima alta: 4, estada mínima baja: 2
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }


    public float getMetres() {
        return mida;
    }


    public boolean correcteFuncionament() {
        return isOperatiu();
    }

    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}