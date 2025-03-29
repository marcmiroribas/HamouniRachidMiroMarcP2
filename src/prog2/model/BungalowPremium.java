package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String idAllotjament,boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament,operatiu,iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean isOperatiu() {
        return super.isOperatiu() && serveisExtra && !codiWifi.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + " BungalowPremium{" +
                "serveisExtra=" + serveisExtra +
                ", codiWifi='" + codiWifi + '\'' +
                '}';
    }
}
