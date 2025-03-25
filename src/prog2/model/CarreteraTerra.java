package prog2.model;

public class CarreteraTerra extends AccesTerra {
    public CarreteraTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", longitud: " + longitud;
    }
}
