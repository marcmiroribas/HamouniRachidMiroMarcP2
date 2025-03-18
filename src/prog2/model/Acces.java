package prog2.model;

import prog2.model.Allotjament;
import prog2.model.InAcces;
import java.util.ArrayList;
import java.util.List;

public abstract class Acces implements InAcces {
    protected String nom;
    protected boolean accessibilitat;
    protected boolean estat;
    protected List<Allotjament> allotjaments;

    public Acces(String nom, boolean accessibilitat, boolean estat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        allotjaments.add(allotjament);
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }
}

abstract class AccesAsfalt extends Acces {
    protected double metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
}

abstract class AccesTerra extends Acces {
    protected double longitud;

    public AccesTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat);
        this.longitud = longitud;
    }
}

class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}

class CarreteraAsfalt extends AccesAsfalt {
    public CarreteraAsfalt(String nom, boolean accessibilitat, boolean estat, double metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString() {
        return "Carretera Asfalt: " + nom + ", accessibilitat: " + accessibilitat + ", estat: " + estat + ", m² asfalt: " + metresQuadratsAsfalt;
    }
}

class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }
}

class CarreteraTerra extends AccesTerra {
    public CarreteraTerra(String nom, boolean accessibilitat, boolean estat, double longitud) {
        super(nom, accessibilitat, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString() {
        return "Carretera Terra: " + nom + ", accessibilitat: " + accessibilitat + ", estat: " + estat + ", longitud: " + longitud;
    }
}