package daw.programacion.obra;

import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {

        Pintura Guernica = new Pintura(001, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
        Pintura LaVie = new Pintura(002, "La vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
        Pintura ElSueño = new Pintura(003, "El Sueño", "P.Picasso", 300, 1.3, 1, 5, "óleo", "Óleo");
        Pintura RetratoDeDoraMaar = new Pintura(004, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo", "Óleo");
        Escultura ElPielRoja = new Escultura(005, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "null");
        

        int x = 0;
        Scanner read = new Scanner(System.in);
        while(x != 7){

            System.out.println("");
            System.out.println("1. Visualizar las obras de arte existentes en la galería. Permite conocer todas las obras que se exponen.");
            System.out.println("2. Dar de alta una nueva obra de arte.");
            System.out.println("3. Modificar los datos de una de las obras de arte expuestas (se le pedirá al usuario que indique qué obra quiere visualizar).");
            System.out.println("4. Visualizar los datos de una de las obras de arte expuestas (se le pedirá al usuario que indique qué obra quiere visualizar).");
            System.out.println("5. Obtener el precio de venta de una de las obras de arte expuestas (se le pedirá al usuario que indique qué obra quiere visualizar).");
            System.out.println("6. Imprimir una etiqueta para clasificar una de las obras expuestas y dar información adicional a los visitantes de la galería (se le pedirá al usuario que indique qué obra quiere visualizar)");
            System.out.println("7. Salir");
            System.out.println("");
            System.out.print("Indique lo que quiere realizar: ");
            x = read.nextInt();

            switch(x){
                case 1:

                continue;
                case 2:

                continue;
                case 3:

                continue;
                case 4:

                continue;
                case 5:

                continue;
                case 6:

                continue;
                case 7:
                System.out.println("Fin del programa.");
                break;
                default:
                System.out.println("Opción incorrecta.");
                continue;
            }
        }
    }
}
