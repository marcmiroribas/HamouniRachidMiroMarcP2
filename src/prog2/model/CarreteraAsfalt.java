package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    public CarreteraAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", m² asfalt: " + metresQuadratsAsfalt;
    }
}
