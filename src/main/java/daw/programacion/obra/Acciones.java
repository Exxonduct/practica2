package daw.programacion.obra;

import java.util.Scanner;

public class Acciones {
    static Scanner read = new Scanner(System.in);

    public static void printOpciones() {
        System.out.println("");
        System.out.println(
                "1. Visualizar las obras de arte existentes en la galería.");
        System.out.println("2. Dar de alta una nueva obra de arte.");
        System.out.println("3. Modificar los datos de una de las obras de arte expuestas.");
        System.out.println("4. Visualizar los datos de una de las obras de arte expuestas.");
        System.out.println("5. Obtener el precio de venta de una de las obras de arte expuestas.");
        System.out.println(
                "6. Imprimir una etiqueta para clasificar una de las obras expuestas y dar información adicional a los visitantes de la galería.");
        System.out.println("7. Salir");
        System.out.println("");
        System.out.print("Indique lo que quiere realizar: ");

    }

    public static void printObras() {
        System.out.println("");
        System.out.println("Esculturas: ");
        for (int i = 0; i < Almacen.getObras().length; i++) {
            System.out.print("ID: " + Almacen.getObras()[i].getId());
            System.out.print(" Nombre: " + Almacen.getObras()[i].getNombre());
            System.out.print(" Autor: " + Almacen.getObras()[i].getAutor());
            System.out.print(" Precio: " + Almacen.getObras()[i].getPrecio() + " euros");
            System.out.print(" Altura: " + Almacen.getObras()[i].getAltura() + "m");
            System.out.print(" Peso: " + Almacen.getObras()[i].getPeso() + "t");
            if (Almacen.getObras()[i] instanceof Pintura) {
                Pintura pinturaTemp = (Pintura) Almacen.getObras()[i];
                System.out.print(" Técnica: " + pinturaTemp.getTecnica());
            } else if (Almacen.getObras()[i] instanceof Escultura) {
                Escultura esculturaTemp = (Escultura) Almacen.getObras()[i];
                System.out.print(" Material: " + esculturaTemp.getMaterial());
            }
            System.out.print(" Piezas: " + Almacen.getObras()[i].getNumeroPiezas());
            System.out.print(" Descripción: " + Almacen.getObras()[i].getDescripcion());
            System.out.println("");

        }
    }

    public static void crearObra() {
        int id;
        while (true) {
            System.out.print("Introduzca el ID de la nueva obra: ");
            id = read.nextInt();
            boolean repetido = false;
            for (int i = 0; i < Almacen.getObras().length; i++) {
                if (Almacen.getObras()[i].getId() == id) {
                    repetido = true;
                }
            }
            if (repetido) {
                System.out.println("Ya existe una obra con ese ID, por favor, introduzca uno nuevo.");
                continue;
            }
            break;
        }
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
        if (tipo.equals("Pintura")) {
            System.out.print("Introduzca la Técnica de la Pintura: ");
            String tecnica = read.nextLine();
            Pintura creada1 = new Pintura(id, nombre, autor, precio, altura, peso, piezas, desc, tecnica);
            ObraDeArte[] nuevaTemp = new ObraDeArte[Almacen.getObras().length + 1];

            for (int i = 0; i < Almacen.getObras().length; i++) {
                nuevaTemp[i] = Almacen.getObras()[i];
            }

            Almacen.setObras(nuevaTemp);
            Almacen.añadirobra(creada1);

        } else if (tipo.equals("Escultura")) {
            System.out.print("Introduzca el Material de la Escultura: ");
            String material = read.nextLine();
            Escultura creada1 = new Escultura(id, nombre, autor, precio, altura, peso, piezas, desc, material);
            ObraDeArte[] nuevaTemp = new ObraDeArte[Almacen.getObras().length + 1];

            for (int i = 0; i < Almacen.getObras().length; i++) {
                nuevaTemp[i] = Almacen.getObras()[i];
            }

            Almacen.setObras(nuevaTemp);
            Almacen.añadirobra(creada1);

        }
    }

    public static void modificarObra() {
        printObras();
        System.out.print("Introduzca el ID de la obra que quiere modificar: ");
        int idCambiar = read.nextInt();
        read.nextLine();
        for (int i = 0; i < Almacen.getObras().length; i++) {
            if (Almacen.getObras()[i].getId() == idCambiar) {
                System.out.print("Introduzca lo que quiere cambiar: ");
                String queCambiar = read.nextLine();
                switch (queCambiar) {
                    case "id":
                        System.out.print("Introduzca el nuevo ID: ");
                        int nuevoId = read.nextInt();
                        Almacen.getObras()[i].setId(nuevoId);
                        break;
                    case "nombre":
                        System.out.print("Introduzca el nuevo nombre: ");
                        String nuevoNombre = read.nextLine();
                        Almacen.getObras()[i].setNombre(nuevoNombre);
                        break;
                    case "autor":
                        System.out.print("Introduzca el nuevo autor: ");
                        String nuevoAutor = read.nextLine();
                        Almacen.getObras()[i].setAutor(nuevoAutor);
                        break;
                    case "precio":
                        System.out.print("Introduzca el nuevo precio: ");
                        double nuevoPrecio = read.nextDouble();
                        Almacen.getObras()[i].setPrecio(nuevoPrecio);
                        break;
                    case "altura":
                        System.out.print("Introduzca la nueva altura: ");
                        double nuevaAltura = read.nextDouble();
                        Almacen.getObras()[i].setAltura(nuevaAltura);
                        break;
                    case "peso":
                        System.out.print("Introduzca el nuevo peso: ");
                        double nuevoPeso = read.nextDouble();
                        Almacen.getObras()[i].setPeso(nuevoPeso);
                        break;
                    case "material":
                        if (Almacen.getObras()[i] instanceof Escultura) {
                            System.out.print("Introduzca el nuevo material: ");
                            String nuevoMaterial = read.nextLine();
                            Escultura esculturaTemp = (Escultura) Almacen.getObras()[i];
                            esculturaTemp.setMaterial(nuevoMaterial);
                            Almacen.getObras()[i] = esculturaTemp;
                        } else {
                            System.out.println("Esta obra no es una escultura, seleccione una opción correcta.");
                            continue;
                        }
                        break;
                    case "tecnica":
                        if (Almacen.getObras()[i] instanceof Pintura) {
                            System.out.print("Introduzca la nueva Técnica: ");
                            String nuevaTecnica = read.nextLine();
                            Pintura pinturaTemp = (Pintura) Almacen.getObras()[i];
                            pinturaTemp.setTecnica(nuevaTecnica);
                            Almacen.getObras()[i] = pinturaTemp;
                        } else {
                            System.out.println("Esta obra no es una pintura, seleccione una opción correcta.");
                            continue;
                        }
                        break;
                    case "numero de piezas":
                        System.out.print("Introduzca el nuevo numero de piezas: ");
                        int nuevoNumeroDePiezas = read.nextInt();
                        Almacen.getObras()[i].setNumeroPiezas(nuevoNumeroDePiezas);
                        break;
                    case "descripcion":
                        System.out.print("Introduzca la nueva descripción: ");
                        String nuevaDescripcion = read.nextLine();
                        Almacen.getObras()[i].setDescripcion(nuevaDescripcion);
                        break;
                }
            }
        }
    }

}
