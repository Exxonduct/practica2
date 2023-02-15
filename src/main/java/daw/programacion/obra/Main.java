package daw.programacion.obra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int eleccion = 0;
        Scanner read = new Scanner(System.in);

        final int VEROBRAS = 1;
        final int CREAROBRA = 2;
        final int MODIFICARDATOS = 3;
        final int VISUALIZARDATOS = 4;
        final int OBTENERPRECIOVENTA = 5;
        final int IMPRIMIRETIQUETA = 6;
        final int SALIR = 7;

        while (eleccion != SALIR) {
            Acciones.printOpciones();
            try{
                eleccion = read.nextInt();
                read.nextLine();
            }  // lee la elección
            catch(InputMismatchException ime){
                System.out.println("Error, introduzca un parámetro válido.");
                read.next();
                continue;
            } // da error si eleccion no es un número

            switch (eleccion) {
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
                    Acciones.visualizarDatos();
                    continue;
                case OBTENERPRECIOVENTA:
                    Acciones.obtenerPrecioVenta();
                    continue;
                case IMPRIMIRETIQUETA:
                    Acciones.imprimirEtiqueta();
                    continue;
                case SALIR:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    continue;
            }
        } // while la elección no es salir(7)
        read.close();
    }
}
