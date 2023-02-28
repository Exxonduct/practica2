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
            Metodos.printOpciones();
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
                    Metodos.printObras();
                    continue;
                case CREAROBRA:
                    int id;
                    while (true) {
                        System.out.print("Introduzca el ID de la nueva obra: ");
                        id = read.nextInt();
                        boolean repetido = false;
                        for (int i = 0; i < Galeria.getObras().length; i++) {
                            if (Galeria.getObras()[i].getId() == id) {
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

                    Galeria.crearObra(id, tipo, nombre, autor, precio, altura, peso, piezas, desc, tecnica_o_material);
                    continue;
                case MODIFICARDATOS:
                    System.out.print("Introduzca el ID de la obra que quiere modificar: ");
                    int idCambiar = read.nextInt();
                    read.nextLine();
                    for (int i = 0; i < Galeria.getObras().length; i++) {
                        if (Galeria.getObras()[i].getId() == idCambiar) {
                            System.out.print("Introduzca lo que quiere cambiar(en minusculas): ");
                            String queCambiar = read.nextLine();
                            switch (queCambiar) {
                                case "id":
                                    System.out.print("Introduzca el nuevo ID: ");
                                    int nuevoId = read.nextInt();
                                    Galeria.getObras()[i].setId(nuevoId);
                                    break;
                                case "nombre":
                                    System.out.print("Introduzca el nuevo nombre: ");
                                    String nuevoNombre = read.nextLine();
                                    Galeria.getObras()[i].setNombre(nuevoNombre);
                                    break;
                                case "autor":
                                    System.out.print("Introduzca el nuevo autor: ");
                                    String nuevoAutor = read.nextLine();
                                    Galeria.getObras()[i].setAutor(nuevoAutor);
                                    break;
                                case "precio":
                                    System.out.print("Introduzca el nuevo precio: ");
                                    double nuevoPrecio = read.nextDouble();
                                    Galeria.getObras()[i].setPrecio(nuevoPrecio);
                                    break;
                                case "altura":
                                    System.out.print("Introduzca la nueva altura: ");
                                    double nuevaAltura = read.nextDouble();
                                    Galeria.getObras()[i].setAltura(nuevaAltura);
                                    break;
                                case "peso":
                                    System.out.print("Introduzca el nuevo peso: ");
                                    double nuevoPeso = read.nextDouble();
                                    Galeria.getObras()[i].setPeso(nuevoPeso);
                                    break;
                                case "material":
                                    if (Galeria.getObras()[i] instanceof Escultura) {
                                        System.out.print("Introduzca el nuevo material: ");
                                        String nuevoMaterial = read.nextLine();
                                        Escultura esculturaTemp = (Escultura) Galeria.getObras()[i];
                                        esculturaTemp.setMaterial(nuevoMaterial);
                                        Galeria.getObras()[i] = esculturaTemp;
                                    } // if es una escultura se puede cambiar el material
                                    else {
                                        System.out.println(
                                                "Esta obra no es una escultura, seleccione una opción correcta.");
                                        continue;
                                    } // if no es una escultura no se puede cambiar el material
                                    break;
                                case "tecnica":
                                    if (Galeria.getObras()[i] instanceof Pintura) {
                                        System.out.print("Introduzca la nueva Técnica: ");
                                        String nuevaTecnica = read.nextLine();
                                        Pintura pinturaTemp = (Pintura) Galeria.getObras()[i];
                                        pinturaTemp.setTecnica(nuevaTecnica);
                                        Galeria.getObras()[i] = pinturaTemp;
                                    } // if es una pintura se puede cambiar la técnica
                                    else {
                                        System.out.println(
                                                "Esta obra no es una pintura, seleccione una opción correcta.");
                                        continue;
                                    } // if no es una pintura no se puede cambiar la técnica
                                    break;
                                case "numero de piezas":
                                    System.out.print("Introduzca el nuevo numero de piezas: ");
                                    int nuevoNumeroDePiezas = read.nextInt();
                                    Galeria.getObras()[i].setNumeroPiezas(nuevoNumeroDePiezas);
                                    break;
                                case "descripcion":
                                    System.out.print("Introduzca la nueva descripción: ");
                                    String nuevaDescripcion = read.nextLine();
                                    Galeria.getObras()[i].setDescripcion(nuevaDescripcion);
                                    break;
                            } // switch para lo que quieres cambiar
                        } // if el id introducido coincide con la obra se modifica esa obra
                    } // for que recorre todas las obras
                    continue;
                case VISUALIZARDATOS:
                    boolean idNoExiste = true;
                    while (idNoExiste) {
                        System.out.print("Introduzca el ID de la obra que quiere visualizar:");
                        int idVisualizar = read.nextInt();
                        for (int i = 0; i < Galeria.getObras().length; i++) {
                            if (Galeria.getObras()[i].getId() == idVisualizar) {
                                Metodos.printUnaObra(Galeria.getObras()[i]);
                                idNoExiste = false;
                            } // if el id existe se printea la obra y se finaliza el bucle
                        } // for que recorre todas las obras
                        if (idNoExiste) {
                            System.out.println("El ID que ha introducido no está registrado, introduzca otro.");
                        } // if no existe el id se repite el bucle
                    } // while para que te printee solo una obra con un ID existente
                    continue;
                case OBTENERPRECIOVENTA:
                    idNoExiste = true;
                    while (idNoExiste) {
                        System.out.print("Introduzca el ID de la obra de la que quiere obtener el precio de venta:");
                        int idObtenerPrecio = read.nextInt();
                        for (int i = 0; i < Galeria.getObras().length; i++) {
                            if (Galeria.getObras()[i].getId() == idObtenerPrecio) {
                                System.out.println("Nombre: " + Galeria.getObras()[i].getNombre());
                                System.out.println("Altura(m): " + Galeria.getObras()[i].getAltura());
                                System.out.println("Peso(t): " + Galeria.getObras()[i].getPeso());
                                System.out.println("Numero de piezas: " + Galeria.getObras()[i].getNumeroPiezas());
                                System.out.println("Precio(euros): " + Galeria.getObras()[i].getPrecio());
                                System.out.println("Comisión galería: " + Galeria.sacarComisionGaleria(Galeria.getObras()[i]));
                                System.out.println("Importe por peso: " + Galeria.sacarPrecioMasDeUnKg(Galeria.getObras()[i]));
                                System.out.println("Importe por altura: " + Galeria.sacarPrecioMasDeDosMetros(Galeria.getObras()[i]));
                                if (Galeria.sacarPrecioMasDeDosPiezas(Galeria.getObras()[i]) != 0) {
                                    System.out.println("Importe adicional por piezas: " + Galeria.sacarPrecioMasDeDosPiezas(Galeria.getObras()[i]));
                                } // if tiene mas de dos piezas
                                if (Galeria.getObras()[i] instanceof Pintura) {
                                    System.out.println(
                                            "Precio de venta(descuento del 10% por ser pintura): " + Galeria.sacarPrecioVenta(Galeria.getObras()[i]));
                                } // if es pintura
                                else {
                                    System.out.println(
                                            "Precio de venta(descuento del 20% por ser escultura + 50euros de manipulación): "
                                                    + Galeria.sacarPrecioVenta(Galeria.getObras()[i]));
                                } // if es escultura
                                System.out.println("Precio final(en dólares): " + Galeria.sacarPrecioFinal(Galeria.getObras()[i]) + "$");
                                idNoExiste = false;
                            } // if el id existe se printea la obra y se finaliza el bucle
                        } // for que recorre todas las obras
                        if (idNoExiste) {
                            System.out.println("El ID que ha introducido no está registrado, introduzca otro.");
                        } // if no existe el id se repite el bucle
                    } // while para que te printee solo una obra con un ID existente
                    continue;
                case IMPRIMIRETIQUETA:
                    idNoExiste = true;
                    while (idNoExiste) {
                        System.out.print("Introduzca el ID de la obra que quiere tener la etiqueta: ");
                        int idEtiqueta = read.nextInt();
                        for (int i = 0; i < Galeria.getObras().length; i++) {
                            if (Galeria.getObras()[i].getId() == idEtiqueta) {
                                Metodos.printEtiqueta(Galeria.getObras()[i]);
                                idNoExiste = false;
                            }
                        }
                        if (idNoExiste) {
                            System.out.println("El id que ha introducido no existe, por favor introudzca uno nuevo.");
                            continue;
                        }

                    }
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
