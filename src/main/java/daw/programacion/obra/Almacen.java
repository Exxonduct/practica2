package daw.programacion.obra;

public class Almacen {

    public static Pintura guernica = new Pintura(001, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil",
            "Óleo");
    public static Pintura laVie = new Pintura(002, "La vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
    public static Pintura elSueño = new Pintura(003, "El Sueño", "P.Picasso", 300, 1.3, 1, 5, "óleo", "Óleo");
    public static Pintura retratoDeDoraMaar = new Pintura(004, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1,
            "óleo",
            "Óleo");
    static Escultura elPielRoja = new Escultura(005, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "null");

    private static ObraDeArte[] obras = { guernica, laVie, elSueño, retratoDeDoraMaar, elPielRoja };

    public static ObraDeArte[] getObras() {
        return obras;
    }

    public static void setObras(ObraDeArte[] obras) {
        Almacen.obras = obras;
    }

    public static void añadirobra(ObraDeArte obra){
        Almacen.obras[obras.length - 1] = obra;
    } // se añade una obra a la última posición libre del array
    
    

    

}
