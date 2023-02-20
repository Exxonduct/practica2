package daw.programacion.obra;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.security.auth.callback.TextInputCallback;

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
            try {
                eleccion = read.nextInt();
                read.nextLine();
            } // lee la elección
            catch (InputMismatchException ime) {
                System.out.println("Error, introduzca un parámetro válido.");
                read.next();
                continue;
            } // da error si eleccion no es un número

            switch (eleccion) {
                case VEROBRAS:
                    Acciones.printObras();
                    continue;
                case CREAROBRA:
                    int id;
                    while (true) {
                        System.out.print("Introduzca el ID de la nueva obra: ");
                        id = read.nextInt();
                        boolean repetido = false;
                        for (int i = 0; i < Almacen.getObras().length; i++) {
                            if (Almacen.getObras()[i].getId() == id) {
                                repetido = true;
                            } // if hay un id que ya existe repetido = true
                        }
                        if (repetido) {
                            System.out.println("Ya existe una obra con ese ID, por favor, introduzca uno nuevo.");
                            continue;
                        } // si está repetido te vuelve a pedir el id
                        break;
                    } // while para introducir un ID único y nuevo
                    System.out.print("Introduzca el tipo de obra que quiere crear(Pintura/Escultura): ");
                    read.nextLine();
                    String tipo = read.nextLine();
                    System.out.print("Introduzca el Nombre de la obra: ");
                    String nombre = read.nextLine();
                    System.out.print("Introduzca el nombre del Autor: ");
                    String autor = read.nextLine();
                    System.out.print("Introduzca el precio: ");
                    double precio = read.nextDouble();
                    System.out.print("Introduzca la altura: ");
                    double altura = read.nextDouble();
                    System.out.print("Introduzca el peso: ");
                    double peso = read.nextDouble();
                    System.out.print("Introduzca el número de piezas: ");
                    int piezas = read.nextInt();
                    read.nextLine();
                    System.out.print("Introduzca la descripción: ");
                    String desc = read.nextLine();
                    String tecnica_o_material = "";
                    if (tipo.equals("Pintura")) {
                        System.out.print("Introduzca la Técnica de la Pintura: ");
                        tecnica_o_material = read.nextLine();
                    } // if quiere introducir una pintura
                    else if (tipo.equals("Escultura")) {
                        System.out.print("Introduzca el Material de la Escultura: ");
                        tecnica_o_material = read.nextLine();
                    } // if quiere introducir una escultura

                    Acciones.crearObra(id, tipo, nombre, autor, precio, altura, peso, piezas, desc, tecnica_o_material);
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
