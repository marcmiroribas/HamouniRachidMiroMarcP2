package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import prog2.vista.ExcepcioCamping;

public class LlistaAccessos implements InLlistaAccessos{
    private List<Acces> accessos;

    public LlistaAccessos() {
        this.accessos = new ArrayList<>();
    }

    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (acc == null) {
            throw new ExcepcioCamping("L'accés no pot ser null");
        }

        if (accessos.contains(acc)) {
            throw new ExcepcioCamping("L'accés ja existeix a la llista");
        }
        accessos.add(acc);
    }
    public void buidar() {
        accessos.clear();
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder resultat = new StringBuilder();
        boolean trobat = false;

        for (Acces acc : accessos) {
            if (acc.estat == estat) {
                resultat.append(acc.toString()).append("\n");
                trobat = true;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("No hi ha accessos en l'estat indicat.");
        }

        return resultat.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator <Acces> itr = accessos.iterator();
        while (itr.hasNext()){
            Acces a = itr.next();
            if (a.isEmpty()){
                a.tancarAcces();
            }
            if (!a.isEmpty()){
                a.obrirAcces();
            }
        }
        System.out.println("Estats actualitzats");
    }


    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int count = 0;
        for (Acces acc : accessos) {
            if (acc.isAccessibilitat()) {
                count++;
            }
        }
        return count;
    }

    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float total = 0;
        for (Acces acc : accessos) {
            if (acc instanceof AccesAsfalt) {
                total += ((AccesAsfalt) acc).metresQuadratsAsfalt;
            }
        }
        return total;
    }
}
