package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private float amplada;
    public CarreteraTerra(String nom, boolean accessibilitat, float longitud, float amplada) {
        super(nom, accessibilitat, longitud);
        this.amplada= amplada;
    }
    public float getAmplada() {
        return amplada;
    }
    public void setAmplada(float amplada) {
        this.amplada = amplada;
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
