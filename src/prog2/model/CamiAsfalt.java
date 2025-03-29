package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean accessibilitat,double metresQuadratsAsfalt) {
        super(nom, accessibilitat,metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}
