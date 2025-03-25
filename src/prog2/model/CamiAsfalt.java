package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}
