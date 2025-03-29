package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean accessibilitat,float longitud) {
        super(nom, accessibilitat,longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}
