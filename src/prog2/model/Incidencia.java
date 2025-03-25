package prog2.model;


public class Incidencia {
    private int num;
    private Allotjament allotjament;
    private String data;
    private TipusIncidencia tipusIncidencia;


    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    }
    // Constrctor de la classe amb parametres
    public Incidencia(int num, TipusIncidencia tipus, Allotjament allotjament, String data) {
        this.num = num;
        this.allotjament = allotjament;
        this.data = data;
        this.tipusIncidencia = tipus;
    }

    // Getters
    public int getNum() {
        return this.num;
    }

    public Allotjament getAllotjament() {
        return this.allotjament;
    }

    public String getData() {
        return this.data;
    }

    public TipusIncidencia getTipusIncidencia() {
        return this.tipusIncidencia;

    }

    // Setters
    public void setNum(int num) {
        this.num = num;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipusIncidencia(TipusIncidencia tipusIncidencia) {
        this.tipusIncidencia = tipusIncidencia;
    }
    

    // Metode toString implementat a incidencia
    public String toString() {
        return "Incidència núm: " + num + ", Data: " + data + ", Tipus: " + tipusIncidencia +
                ", Allotjament: [" + allotjament.toString() + "]";
    }

    public String getIluminacioAllotjament() {
        switch (tipusIncidencia) {
            case Reparacio:
                return "S'ha de deixar una iluminació del 100%";
            case Neteja:
                return "S'ha de deixar una iluminació del 50%";
            case Tancament:
                return "S'ha de deixar una iluminació del 0%";
            default:
                return "ERROR";
        }
    }
}
