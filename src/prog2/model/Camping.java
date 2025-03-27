package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.*;
import java.util.ArrayList;

public class Camping implements InCamping {
    private ArrayList<Allotjament> allotjaments;
    private LlistaIncidencies llistaIncidencies;
    private LlistaAccessos llistaAccessos;

    public Camping() {
        this.allotjaments = new ArrayList<>();
        this.llistaIncidencies = new LlistaIncidencies();
        this.llistaAccessos = new LlistaAccessos();
    }

    public String getNomCamping() {
        return "Camping Green";
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "Llistat d'allotjaments en estat: " + estat;
    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "Llistat d'accessos en estat: " + infoEstat;
    }

    public String llistarIncidencies() throws ExcepcioCamping {
        return llistaIncidencies.toString();
    }

    public void afegirIncidencia(int numIncidencia, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        Allotjament allotjament = getAllotjamentById(idAllotjament);
        if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament amb ID " + idAllotjament + " no existeix.");
        }
        llistaIncidencies.afegirIncidencia(numIncidencia, tipus, allotjament, data);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public void eliminarIncidencia(int numIncidencia) throws ExcepcioCamping {
        Incidencia incidencia = llistaIncidencies.getIncidencia(numIncidencia);
        llistaIncidencies.eliminarIncidencia(incidencia);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public int calculaAccessosAccessibles() {
        return llistaAccessos.calculaAccessosAccessibles();
    }

    public float calculaMetresQuadratsAsfalt() {
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }

    public void load(String camiDesti) throws ExcepcioCamping {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error en desar el fitxer: " + e.getMessage());
        }
    }

    public static Camping save(String camiOrigen) throws ExcepcioCamping {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            return (Camping) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("Error en carregar el fitxer: " + e.getMessage());
        }
    }

    public void inicialitzaDadesCamping() {
        System.out.println("Inicialitzant dades del càmping...");
    }

    private Allotjament getAllotjamentById(String id) {
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}
