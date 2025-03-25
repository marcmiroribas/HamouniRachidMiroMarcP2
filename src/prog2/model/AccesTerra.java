package prog2.model;

abstract class AccesTerra extends Acces {
    protected double longitud;

    public AccesTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat);
        this.longitud = longitud;
    }
}
