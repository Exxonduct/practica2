package daw.programacion.obra;

import java.util.Scanner;

public class Main {

    public static void main( String[] args )
    {


        int x = 0;
        Scanner read = new Scanner(System.in);
        while(x != 7){

            Acciones.printOpciones();
            x = read.nextInt();
            switch(x){
                case 1:
                    ObraDeArte.printObras();
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
