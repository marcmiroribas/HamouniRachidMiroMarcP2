package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}
