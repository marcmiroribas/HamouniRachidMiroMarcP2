package prog2.model;

public class Bungalow extends Allotjament {
    private float mida;
    private int habitacions;
    private int placesPersones;
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, operatiu, iluminacio); // Estada mínima alta: 7, estada mínima baja: 4
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    @Override
    public boolean isOperatiu() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Bungalow{" +
                "mida='" + mida + '\'' +
                ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones +
                ", placesParquing=" + placesParquing +
                ", terrassa=" + terrassa +
                ", tv=" + tv +
                ", aireFred=" + aireFred +
                '}';
    }
}
