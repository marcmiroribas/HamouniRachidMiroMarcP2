package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions,
                           int placesPersones, int placesParquing, boolean terrassa,
                           boolean tv, boolean aireFred, boolean serveisExtra,
                           String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing,
                terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // Getters específicos
    public boolean teServeisExtra() {
        return serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    @Override
    public boolean correcteFuncionament() {
        return super.correcteFuncionament() && serveisExtra && (codiWifi != null && !codiWifi.isEmpty());
    }

    @Override
    public String toString() {
        return "BungalowPremium [" + super.toString() +
                ", serveisExtra=" + (serveisExtra ? "Sí" : "No") +
                ", codiWifi=" + (codiWifi != null ? codiWifi : "No disponible") + "]";
    }
}
