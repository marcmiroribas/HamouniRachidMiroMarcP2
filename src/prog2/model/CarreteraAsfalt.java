package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMaxim;

    public CarreteraAsfalt(String nom, boolean accessibilitat,double metresQuadratsAsfalt,float pesMaxim) {
        super(nom, accessibilitat, metresQuadratsAsfalt);
        this.pesMaxim= pesMaxim;
    }
    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
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
