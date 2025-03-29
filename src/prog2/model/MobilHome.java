package prog2.model;

public class MobilHome extends Allotjament {
    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3); // Estada mínima alta: 5, estada mínima baja: 3
        this.terrassaBarbacoa = terrassaBarbacoa;
    }


    public boolean correcteFuncionament() {
        return isOperatiu();
    }

    @Override
    public String toString() {
        return super.toString() + " MobilHome{" +
                "terrassaBarbacoa=" + terrassaBarbacoa +
                '}';
    }
}