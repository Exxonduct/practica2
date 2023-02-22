package daw.programacion.obra;

import java.util.Scanner;

public class Metodos {
   
    public static void printOpciones() {
        String[] opciones = { "1. Visualizar las obras de arte existentes en la galería.",
                "2. Dar de alta una nueva obra de arte.",
                "3. Modificar los datos de una de las obras de arte expuestas.",
                "4. Visualizar los datos de una de las obras de arte expuestas.",
                "5. Obtener el precio de venta de una de las obras de arte expuestas.",
                "6. Imprimir una etiqueta para clasificar una de las obras expuestas y dar información adicional a los visitantes de la galería.",
                "7. Salir" };

        System.out.println("");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(opciones[i]);
        } // printea todas las opciones
        System.out.println("");
        System.out.print("Indique lo que quiere realizar: ");

    } // metodo para printear las opciones disponibles

    
    public static void printUnaObra(ObraDeArte obras) {
        if (obras instanceof Pintura) {
            Pintura pinturaTemp = (Pintura) obras;
            System.out.println(pinturaTemp.toString());
        } // if la obra es una pintura
        else if (obras instanceof Escultura) {
            Escultura esculturaTemp = (Escultura) obras;
            System.out.println(esculturaTemp.toString());
        } // if la obra es una escultura

    } // metodo para printear una obra en concreto

    public static void printObras() {
        System.out.println("");
        for (int i = 0; i < Galeria.getObras().length; i++) {

            printUnaObra(Galeria.getObras()[i]);

        } // for que recorre todas las obras
    } // metodo con un for que printea todas las obras de arte

    public static void printEtiqueta(ObraDeArte obra){
        System.out.println("");
        System.out.println("Nombre: " + obra.getNombre());
        System.out.println("Autor: " + obra.getAutor());
        System.out.println("Descripción: " + obra.getDescripcion());
    }


}
