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

    } // metodo para printear las opciones disponibles

    public static void printUnaObra(ObraDeArte obras) {
        System.out.println("");
        System.out.println("ID: " + obras.getId());
        System.out.println("Nombre: " + obras.getNombre());
        System.out.println("Autor: " + obras.getAutor());
        System.out.println("Precio: " + obras.getPrecio() + " euros");
        System.out.println("Altura: " + obras.getAltura() + "m");
        System.out.println("Peso: " + obras.getPeso() + "t");
        if (obras instanceof Pintura) {
            Pintura pinturaTemp = (Pintura) obras;
            System.out.println("Técnica: " + pinturaTemp.getTecnica());
        } // if la obra es una pintura 
        else if (obras instanceof Escultura) {
            Escultura esculturaTemp = (Escultura) obras;
            System.out.println("Material: " + esculturaTemp.getMaterial());
        } // if la obra es una escultura
        System.out.println("Piezas: " + obras.getNumeroPiezas());
        System.out.println("Descripción: " + obras.getDescripcion());
        System.out.println("");

    } // metodo para printear una obra en concreto

    public static void printObras() {
        System.out.println("");
        System.out.println("Esculturas: ");
        for (int i = 0; i < Almacen.getObras().length; i++) {

            printUnaObra(Almacen.getObras()[i]);

        } // for que recorre todas las obras
    } // metodo con un for que printea todas las obras de arte

    public static void crearObra() {
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
        if (tipo.equals("Pintura")) {
            System.out.print("Introduzca la Técnica de la Pintura: ");
            String tecnica = read.nextLine();
            Pintura creada1 = new Pintura(id, nombre, autor, precio, altura, peso, piezas, desc, tecnica);
            ObraDeArte[] nuevaTemp = new ObraDeArte[Almacen.getObras().length + 1];

            for (int i = 0; i < Almacen.getObras().length; i++) {
                nuevaTemp[i] = Almacen.getObras()[i];
            } // se guardan las obras en un array temporal con un espacio más

            Almacen.setObras(nuevaTemp); // se meten las obras que ya estaban 
            Almacen.añadirobra(creada1); // se mete la obra nueva

        } // if quiere introducir una pintura 
        else if (tipo.equals("Escultura")) {
            System.out.print("Introduzca el Material de la Escultura: ");
            String material = read.nextLine();
            Escultura creada1 = new Escultura(id, nombre, autor, precio, altura, peso, piezas, desc, material);
            ObraDeArte[] nuevaTemp = new ObraDeArte[Almacen.getObras().length + 1];

            for (int i = 0; i < Almacen.getObras().length; i++) {
                nuevaTemp[i] = Almacen.getObras()[i];
            } // se guardan las obras en un array temporal con un espacio más

            Almacen.setObras(nuevaTemp); // se meten las obras que ya estaban 
            Almacen.añadirobra(creada1); // se mete la obra nueva

        } // if quiere introducir una escultura
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
                        } // if es una escultura se puede cambiar el material
                        else {
                            System.out.println("Esta obra no es una escultura, seleccione una opción correcta.");
                            continue;
                        } // if no es una escultura no se puede cambiar el material
                        break;
                    case "tecnica":
                        if (Almacen.getObras()[i] instanceof Pintura) {
                            System.out.print("Introduzca la nueva Técnica: ");
                            String nuevaTecnica = read.nextLine();
                            Pintura pinturaTemp = (Pintura) Almacen.getObras()[i];
                            pinturaTemp.setTecnica(nuevaTecnica);
                            Almacen.getObras()[i] = pinturaTemp;
                        } // if es una pintura se puede cambiar la técnica 
                        else {
                            System.out.println("Esta obra no es una pintura, seleccione una opción correcta.");
                            continue;
                        } // if no es una pintura no se puede cambiar la técnica
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
                } // switch para lo que quieres cambiar
            } // if el id introducido coincide con la obra se modifica esa obra
        } // for que recorre todas las obras
    }

    public static void visualizarDatos() {
        boolean idNoExiste = true;
        while (idNoExiste) {
            System.out.print("Introduzca el ID de la obra que quiere visualizar:");
            int idVisualizar = read.nextInt();
            for (int i = 0; i < Almacen.getObras().length; i++) {
                if (Almacen.getObras()[i].getId() == idVisualizar) {
                    printUnaObra(Almacen.getObras()[i]);
                    idNoExiste = false;
                } // if el id existe se printea la obra y se finaliza el bucle
            } // for que recorre todas las obras
            if (idNoExiste) {
                System.out.println("El ID que ha introducido no está registrado, introduzca otro.");
            } // if no existe el id se repite el bucle
        } // while para que te printee solo una obra con un ID existente
    }

}
