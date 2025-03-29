package prog2.model;

public class Glamping extends Allotjament {
    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, idAllotjament,operatiu, iluminacio,5, 3); // Estada mínima alta: 5, estada mínima baja: 3
        this.material = material;
        this.casaMascota = casaMascota;
    }


    public boolean correcteFuncionament() {
        return isOperatiu();
    }

    @Override
    public String toString() {
        return super.toString() + " Glamping{" +
                "material='" + material + '\'' +
                ", casaMascota=" + casaMascota +
                '}';
    }
}
