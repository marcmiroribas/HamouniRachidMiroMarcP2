package prog2.vista;

import prog2.model.Camping;
import java.util.Scanner;

public class VistaCamping {
    private Camping camping;
    private Menu<OpcionsMenu> menu;

    private enum OpcionsMenu {
        OPCIO1("Opció 1"),
        OPCIO2("Opció 2"),
        GUARDAR_CAMPING("Guardar càmping"),
        RECUPERAR_CAMPING("Recuperar càmping"),
        SORTIR("Sortir");

        private final String descripcio;

        OpcionsMenu(String descripcio) {
            this.descripcio = descripcio;
        }

        @Override
        public String toString() {
            return descripcio;
        }
    }

    public VistaCamping(String nomCamping) {
        camping = new Camping();
        camping.inicialitzaDadesCamping();
        menu = new Menu<>("Menú Camping", OpcionsMenu.values());
    }

    public void gestioCamping() {
        boolean sortir = false;
        Scanner scanner = new Scanner(System.in);
        while (!sortir) {
            menu.mostrarMenu();
            OpcionsMenu opcio = menu.getOpcio(scanner);
            switch (opcio) {
                case OPCIO1:
                    // Implementar acció per a l'opció 1
                    break;
                case OPCIO2:
                    // Implementar acció per a l'opció 2
                    break;
                case GUARDAR_CAMPING:
                    guardarCamping();
                    break;
                case RECUPERAR_CAMPING:
                    recuperarCamping();
                    break;
                case SORTIR:
                    sortir = true;
                    break;
            }
        }
    }

    private void guardarCamping() {
        try {
            camping.save("Camping.dat");
            System.out.println("Càmping guardat correctament.");
        } catch (ExcepcioCamping e) {
            System.err.println("Error en desar el càmping: " + e.getMessage());
        }
    }

    private void recuperarCamping() {
        try {
            camping = Camping.load("Camping.dat");
            System.out.println("Càmping carregat correctament.");
        } catch (ExcepcioCamping e) {
            System.err.println("Error en carregar el càmping: " + e.getMessage());
        }
    }
}
