package prog2.model;

public class Bungalow extends Allotjament {
    private String mida;
    private int habitacions;
    private int placesPersones;
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom, String idAllotjament, String mida, int habitacions,
                    int placesPersones, int placesParquing, boolean terrassa,
                    boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4); // Estada mínima alta: 7, estada mínima baja: 4
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public boolean correcteFuncionament() {
        return isOperatiu();
    }

    // Getters específicos de Bungalow
    public String getMida() {
        return mida;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public int getPlacesPersones() {
        return placesPersones;
    }

    public int getPlacesParquing() {
        return placesParquing;
    }

    public boolean teTerrassa() {
        return terrassa;
    }

    public boolean teTv() {
        return tv;
    }

    public boolean teAireFred() {
        return aireFred;
    }

    @Override
    public String toString() {
        return "Bungalow [" + super.toString() +
                ", mida=" + mida +
                ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones +
                ", placesParquing=" + placesParquing +
                ", terrassa=" + (terrassa ? "Sí" : "No") +
                ", tv=" + (tv ? "Sí" : "No") +
                ", aireFred=" + (aireFred ? "Sí" : "No") + "]";
    }
}