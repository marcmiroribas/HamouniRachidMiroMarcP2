package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean correcteFuncionament() {
        return super.correcteFuncionament() && serveisExtra && !codiWifi.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + " BungalowPremium{" +
                "serveisExtra=" + serveisExtra +
                ", codiWifi='" + codiWifi + '\'' +
                '}';
    }
}
