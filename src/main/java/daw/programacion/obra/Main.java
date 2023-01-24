package daw.programacion.obra;

import java.util.Scanner;

public class Main {

    public static void printPinturas(Pintura[] pinturas){
        for(int i = 0;i<pinturas.length;i++){
            System.out.print("ID: "+pinturas[i].getId());
            System.out.print(" Nombre: "+pinturas[i].getNombre());
            System.out.print(" Autor: "+pinturas[i].getAutor());
            System.out.print(" Técnica: "+pinturas[i].getTecnica());
            System.out.print(" Precio: "+pinturas[i].getPrecio()+" euros");
            System.out.print(" Altura: "+pinturas[i].getAltura()+"m");
            System.out.print(" Peso: "+pinturas[i].getPeso()+"t");
            System.out.print(" Piezas: "+pinturas[i].getNumeroPiezas());
            System.out.print(" Descripción: "+pinturas[i].getDescripcion());
            System.out.println("");

        }
    }

    public static void printEsculturas(Escultura[] esculturas){
        for(int i = 0;i<esculturas.length;i++){
            System.out.print("ID: "+esculturas[i].getId());
            System.out.print(" Nombre: "+esculturas[i].getNombre());
            System.out.print(" Autor: "+esculturas[i].getAutor());
            System.out.print(" Técnica: "+esculturas[i].getMaterial());
            System.out.print(" Precio: "+esculturas[i].getPrecio()+" euros");
            System.out.print(" Altura: "+esculturas[i].getAltura()+"m");
            System.out.print(" Peso: "+esculturas[i].getPeso()+"t");
            System.out.print(" Piezas: "+esculturas[i].getNumeroPiezas());
            System.out.print(" Descripción: "+esculturas[i].getDescripcion());
            System.out.println("");

        }
    }

    public static void printOpciones(){
        System.out.println("");
        System.out.println("1. Visualizar las obras de arte existentes en la galería. Permite conocer todas las obras que se exponen.");
        System.out.println("2. Dar de alta una nueva obra de arte.");
        System.out.println("3. Modificar los datos de una de las obras de arte expuestas.");
        System.out.println("4. Visualizar los datos de una de las obras de arte expuestas.");
        System.out.println("5. Obtener el precio de venta de una de las obras de arte expuestas.");
        System.out.println("6. Imprimir una etiqueta para clasificar una de las obras expuestas y dar información adicional a los visitantes de la galería.");
        System.out.println("7. Salir");
        System.out.println("");
        System.out.print("Indique lo que quiere realizar: ");
    }


    public static void main( String[] args )
    {

        Pintura guernica = new Pintura(001, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
        Pintura laVie = new Pintura(002, "La vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
        Pintura elSueño = new Pintura(003, "El Sueño", "P.Picasso", 300, 1.3, 1, 5, "óleo", "Óleo");
        Pintura retratoDeDoraMaar = new Pintura(004, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo", "Óleo");
        Escultura elPielRoja = new Escultura(005, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "null");
        
        Pintura[] pinturas = {guernica, laVie, elSueño, retratoDeDoraMaar};
        Escultura[] esculturas = {elPielRoja};

        int x = 0;
        Scanner read = new Scanner(System.in);
        while(x != 7){

            printOpciones();
            x = read.nextInt();

            switch(x){
                case 1:
                    System.out.println("");
                    System.out.println("Pinturas:");
                    printPinturas(pinturas);
                    System.out.println("");
                    System.out.println("Esculturas: ");
                    printEsculturas(esculturas);
                continue;
                case 2:

                    System.out.print("Introduzca el ID de la nueva obra: ");
                    int id = read.nextInt();
                    System.out.print("Introduzca el tipo de obra que quiere crear(Pintura/Escultura): ");
                    String s = read.nextLine();
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
                    String g = read.nextLine();
                    System.out.print("Introduzca la descripción: ");
                    String desc = read.nextLine();
                    if(tipo.equals("Pintura")){
                        System.out.print("Introduzca la Técnica de la Pintura: ");
                        String tecnica = read.nextLine();
                        Pintura creada1 = new Pintura(id, nombre, autor, precio, altura, peso, piezas, desc, tecnica);
                        Pintura[] pinturasNueva = new Pintura[pinturas.length+1];

                        for(int i=0;i<pinturas.length;i++){
                            pinturasNueva[i] = pinturas[i];
                        }

                        pinturas = new Pintura[pinturasNueva.length];

                        for(int i=0;i<pinturas.length;i++){
                            pinturas[i] = pinturasNueva[i];
                        }

                        pinturas[pinturas.length-1] = creada1;

                    }
                    else if(tipo.equals("Escultura")){
                        System.out.print("Introduzca el Material de la Escultura: ");
                        String material = read.nextLine();
                        Escultura creada1 = new Escultura(id, nombre, autor, precio, altura, peso, piezas, desc, material);
                        Escultura[] esculturasNueva = new Escultura[esculturas.length+1];

                        for(int i=0;i<esculturas.length;i++){
                            esculturasNueva[i] = esculturas[i];
                        }

                        esculturas = new Escultura[esculturasNueva.length];

                        for(int i=0;i<esculturas.length;i++){
                            esculturas[i] = esculturasNueva[i];
                        }

                        esculturas[esculturas.length-1] = creada1;

                    }

                

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
