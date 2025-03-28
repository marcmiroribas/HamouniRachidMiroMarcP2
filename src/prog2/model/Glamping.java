package prog2.model;

public class Glamping extends Allotjament {
    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String idAllotjament,boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, idAllotjament, 5, 3, operatiu, iluminacio); // Estada mínima alta: 5, estada mínima baja: 3
        this.material = material;
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean isOperatiu() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Glamping{" +
                "material='" + material + '\'' +
                ", casaMascota=" + casaMascota +
                '}';
    }
}
