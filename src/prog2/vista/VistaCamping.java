package prog2.vista;

import prog2.model.Camping;
import prog2.vista.ExcepcioCamping;
import prog2.vista.Menu;

import java.util.Scanner;

public class VistaCamping {
    private Camping camping;

    static private enum opcionsMenu{ALLOTJAMENTS, ALLOTJAMENTS_OPERATIUS, ALLOTJAMENTS_NO_OPERATIUS, ACCESSOS_OBERTS, ACCESSOS_TANCATS,
        INCIDENCIES, AFEGIR_INCIDENCIA, ELIMINAR_INCIDENCIA, ACCESSOS_ACCESSIBILITAT, CALCULAR_M2, GUARDAR, RECUPERAR,SORTIR}

    static private String[] descripcionsMenu={"Llistar la informació de tots els allotjaments", "Llistar la informació dels allotjaments operatius", "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts", "Llistar la informació dels accessos tancats", "Llistar la informació de les incidències actuals","Afegir una incidència", "Eliminar una incidència",
            "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe", "Calcular i mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats",
            " Guardar càmping" , "Recuperar Càmping", "Sortir de l’aplicació"};

    public VistaCamping (String nom){
        this.camping = new Camping();
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping(){
        Scanner sc = new Scanner(System.in);
        Menu<opcionsMenu> menu = new Menu <> ("Camping Green", opcionsMenu.values());
        menu.setDescripcions(descripcionsMenu);
        opcionsMenu opcio = null;
        int idIncidencia, num;
        String nom, idAllotjament, data,cami;
        float m2;
        do{
            try {
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);
                switch (opcio) {
                    case ALLOTJAMENTS:
                        System.out.println(camping.llistarAllotjaments("TOTS"));
                        break;
                    case ALLOTJAMENTS_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("OPERATIUS"));
                        break;
                    case ALLOTJAMENTS_NO_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("INOPERATIUS"));
                        break;
                    case ACCESSOS_OBERTS:
                        System.out.println(camping.llistarAccessos("OBERT"));
                        break;
                    case ACCESSOS_TANCATS:
                        System.out.println(camping.llistarAccessos("TANCAT"));
                        break;
                    case INCIDENCIES:
                        System.out.println(camping.llistarIncidencies());
                        break;
                    case AFEGIR_INCIDENCIA:
                        System.out.println("ID de la incidencia: ");
                        idIncidencia = sc.nextInt();
                        System.out.println("Nom: ");
                        nom = sc.next();
                        System.out.println("ID de l'allotjament: ");
                        idAllotjament = sc.next();
                        System.out.println("Data: ");
                        data = sc.next();
                        camping.afegirIncidencia(idIncidencia, nom, idAllotjament, data);
                        break;
                    case ELIMINAR_INCIDENCIA:
                        System.out.println("ID de la incidencia: ");
                        idIncidencia = sc.nextInt();
                        camping.eliminarIncidencia(idIncidencia);
                        break;
                    case ACCESSOS_ACCESSIBILITAT:
                        num = camping.calculaAccessosAccessibles();
                        System.out.println("Hi han " + num + "accessos amb els cuals estàn permesos l'entrada de vehicles");
                        break;
                    case CALCULAR_M2:
                        m2 = camping.calculaMetresQuadratsAsfalt();
                        System.out.println("Hi han un total de " + m2 + " metres quadrats d'asfalt");
                        break;
                    case GUARDAR:
                        System.out.println("Indica el cami del teu fitxer");
                        cami = sc.next();
                        try {
                            camping.save(cami);
                        } catch (ExcepcioCamping e) {
                            throw new ExcepcioCamping("No s'ha pogut guardar el camping");
                        }
                        break;
                    case RECUPERAR:
                        System.out.println("Indica el cami del teu fitxer");
                        cami = sc.next();
                        try {
                            Camping.load(cami);
                        } catch (ExcepcioCamping e) {
                            throw new ExcepcioCamping("No s'ha pogut carregar el camping");
                        }

                    case SORTIR:
                        System.out.println("Sortint del menu...");
                        break;

                }
            }  catch (ExcepcioCamping e) {
                System.err.println("Error " + e.getMessage());
            }




        }while(opcio != opcionsMenu.SORTIR);
    }




}
