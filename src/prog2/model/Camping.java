package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class
Camping implements InCamping {
    private LlistaAllotjaments allotjaments;
    private LlistaIncidencies llistaIncidencies;
    private LlistaAccessos llistaAccessos;

    public Camping() {
        this.allotjaments =new LlistaAllotjaments();
        this.llistaIncidencies = new LlistaIncidencies();
        this.llistaAccessos = new LlistaAccessos();
    }
    public LlistaAllotjaments getLlistaAllotjaments() {
        return this.allotjaments;
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
        return llistaIncidencies.llistarIncidencies();
    }

    public void afegirIncidencia(int numIncidencia, String tipus, String idAllotjament, String data)
            throws ExcepcioCamping {

        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            Allotjament a = it.next();
            if (a.getId().equals(idAllotjament)) {
                llistaIncidencies.afegirIncidencia(numIncidencia, tipus, a, data);
                llistaAccessos.actualitzaEstatAccessos();
                return;
            }
        }

        throw new ExcepcioCamping("L'allotjament amb ID " + idAllotjament + " no existeix.");
    }

    public void eliminarIncidencia(int numIncidencia) throws ExcepcioCamping {
        Incidencia incidencia = llistaIncidencies.getIncidencia(numIncidencia);
        llistaIncidencies.eliminarIncidencia(incidencia);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public int calculaAccessosAccessibles() {
        try {
            return llistaAccessos.calculaAccessosAccessibles();
        } catch (ExcepcioCamping e) {
            System.err.println("Error en calcular accessos accessibles: " + e.getMessage());
            return 0; // Valor per defecte en cas d'error
        }
    }

    public float calculaMetresQuadratsAsfalt() {
        try {
            return llistaAccessos.calculaMetresQuadratsAsfalt();
        } catch (ExcepcioCamping e) {
            System.err.println("Error en calcular metres quadrats asfaltats: " + e.getMessage());
            return 0.0f; // Valor per defecte en cas d'error
        }
    }

    public void save(String camiDesti) throws ExcepcioCamping {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error en desar el fitxer: " + e.getMessage());
        }
    }

    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            return (Camping) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("Error en carregar el fitxer: " + e.getMessage());
        }
    }

    public void inicialitzaDadesCamping() {

            llistaAccessos.buidar();

        try {
            Acces Acc1 = new CamiAsfalt("A1", true,200.0);
            llistaAccessos.afegirAcces(Acc1);

            float asfalt = 800;
            float pesMaxim = 10000;
            Acces Acc2 = new CarreteraAsfalt("A2", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc2);

            float longitud = 100;
            Acces Acc3 = new CamiTerra("A3", true, longitud);
            llistaAccessos.afegirAcces(Acc3);

            longitud = 200;
            float amplada = 3;
            Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc4);

            asfalt = 350;
            Acces Acc5 = new CamiAsfalt("A5", true, asfalt);
            llistaAccessos.afegirAcces(Acc5);

            asfalt = 800;
            pesMaxim = 12000;
            Acces Acc6 = new CarreteraAsfalt("A6", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc6);

            asfalt = 100;
            Acces Acc7 = new CamiAsfalt("A7", true, asfalt);
            llistaAccessos.afegirAcces(Acc7);

            asfalt = 800;
            pesMaxim = 10000;
            Acces Acc8 = new CarreteraAsfalt("A8", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc8);

            longitud = 50;
            Acces Acc9 = new CamiTerra("A9", true, longitud);
            llistaAccessos.afegirAcces(Acc9);

            longitud = 400;
            amplada = 4;
            Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc10);

            longitud = 80;
            Acces Acc11 = new CamiTerra("A11", true, longitud);
            llistaAccessos.afegirAcces(Acc11);

            longitud = 800;
            amplada = 5;
            Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc12);




            /* Pistes */
            allotjaments.buidar();


            // Afegir parcel·les:
            //------------------------------

            String nom = "Parcel·la Nord";
            String idAllotjament = "ALL1";
            float mida = 64.0f;
            boolean connexioElectrica = true;

            Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            allotjaments.afegirAllotjament(ALL1);

            nom = "Parcel·la Sud";
            idAllotjament = "ALL2";

            Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            allotjaments.afegirAllotjament(ALL2);

            // Afegir bungalows:
            //------------------------------

            nom = "Bungalow Nord";
            idAllotjament = "ALL3";
            mida = 22f;
            int habitacions =2;
            int placesPersones = 4;
            int placesParquing = 1;
            boolean terrassa = true;
            boolean tv= true;
            boolean aireFred = true;

            Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            allotjaments.afegirAllotjament(ALL3);


            // Afegir bungalows premium:
            //------------------------------
            nom = "Bungallow Sud";
            idAllotjament = "ALL4";
            mida = 27f;
            habitacions =2;
            placesPersones = 6;
            placesParquing = 1;
            terrassa = true;
            tv= true;
            aireFred = true;
            boolean serveisExtra = true;
            String codiWifi = "CampingDelMarBP1";

            BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            allotjaments.afegirAllotjament(ALL4);

            // Afegir Glamping:
            //------------------------------

            nom = "Glamping Nord";
            idAllotjament = "ALL5";
            mida = 20f;
            habitacions =1;
            placesPersones = 2;
            String material = "Tela";
            boolean casaMascota = true;

            Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
            allotjaments.afegirAllotjament(ALL5);


            // Afegir Mobil-Home:
            //------------------------------

            nom = "Mobil-Home Sud";
            idAllotjament = "ALL6";
            mida = 20f;
            habitacions =  2;
            placesPersones = 4;
            boolean terrassaBarbacoa = true;

            MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
            allotjaments.afegirAllotjament(ALL6);

            /* Accés */
            Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
            Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
            Acc3.afegirAllotjament(ALL3);
            Acc4.afegirAllotjament(ALL3);
            Acc5.afegirAllotjament(ALL4);
            Acc6.afegirAllotjament(ALL4);
            Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
            Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
            Acc9.afegirAllotjament(ALL2);
            Acc10.afegirAllotjament(ALL2);
            Acc11.afegirAllotjament(ALL6);
            Acc12.afegirAllotjament(ALL6);

        }  catch (ExcepcioCamping e) {
            System.err.println("Error " + e.getMessage());
        }

    }


}
