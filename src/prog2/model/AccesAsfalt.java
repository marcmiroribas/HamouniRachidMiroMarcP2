package prog2.model;

public abstract class AccesAsfalt extends Acces {
    protected double metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
}