package daw.programacion.obra;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 0;
        Scanner read = new Scanner(System.in);
        while (x != 7) {
            Acciones.printOpciones();
            x = read.nextInt();
            read.nextLine();

            final int VEROBRAS = 1;
            final int CREAROBRA = 2;
            final int MODIFICARDATOS = 3;
            final int VISUALIZARDATOS = 4;
            final int OBTENERPRECIOVENTA = 5;
            final int IMPRIMIRETIQUETA = 6;
            final int SALIR = 7;

            switch (x) {
                case VEROBRAS:
                    Acciones.printObras();
                continue;
                case CREAROBRA:
                    Acciones.crearObra();
                continue;
                case MODIFICARDATOS:
                    Acciones.modificarObra();
                continue;
                case VISUALIZARDATOS:

                    continue;
                case OBTENERPRECIOVENTA:

                    continue;
                case IMPRIMIRETIQUETA:

                    continue;
                case SALIR:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    continue;
            }
        }
        read.close();
    }
}
