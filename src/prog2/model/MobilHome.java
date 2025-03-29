package prog2.model;

public class MobilHome extends Allotjament {
    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament,boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3, operatiu, iluminacio); // Estada mínima alta: 5, estada mínima baja: 3
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean isOperatiu() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " MobilHome{" +
                "terrassaBarbacoa=" + terrassaBarbacoa +
                '}';
    }
}