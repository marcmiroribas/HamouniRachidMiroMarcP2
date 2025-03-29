package prog2.model;

abstract class AccesTerra extends Acces {
    protected double longitud;

    public AccesTerra(String nom, boolean accessibilitat,float longitud) {
        super(nom, accessibilitat, true);
        this.longitud = longitud;
    }
}
