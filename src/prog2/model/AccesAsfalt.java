package prog2.model;

public abstract class AccesAsfalt extends Acces {
    protected double metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat,double metresQuadratsAsfalt) {
        super(nom, accessibilitat, true);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
}