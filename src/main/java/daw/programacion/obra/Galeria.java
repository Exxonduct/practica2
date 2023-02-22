package daw.programacion.obra;

public class Galeria {

    private static Pintura guernica = new Pintura(001, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil",
            "Óleo");
    private static Pintura laVie = new Pintura(002, "La vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
    private static Pintura elSueño = new Pintura(003, "El Sueño", "P.Picasso", 300, 1.3, 1, 1, "óleo", "Óleo");
    private static Pintura retratoDeDoraMaar = new Pintura(004, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1,
            "óleo",
            "Óleo");
    private static Escultura elPielRoja = new Escultura(005, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura",
            "null");

    private static ObraDeArte[] obras = { guernica, laVie, elSueño, retratoDeDoraMaar, elPielRoja };

    public static ObraDeArte[] getObras() {
        return obras;
    }

    public static void setObras(ObraDeArte[] obrasTemp) {
        obras = obrasTemp;
    }

    public static void añadirobra(ObraDeArte obra) {
        obras[obras.length - 1] = obra;
    } // se añade una obra a la última posición libre del array

    public static void crearObra(int id, String tipo, String nombre, String autor, double precio, double altura,
            double peso, int piezas, String desc, String tecnica_o_material) {
        Pintura creada1 = new Pintura(id, nombre, autor, precio, altura, peso, piezas, desc, tecnica_o_material);
        ObraDeArte[] nuevaTemp = new ObraDeArte[getObras().length + 1];

        for (int i = 0; i < getObras().length; i++) {
            nuevaTemp[i] = getObras()[i];
        } // se guardan las obras en un array temporal con un espacio más

        setObras(nuevaTemp); // se meten las obras que ya estaban
        añadirobra(creada1); // se mete la obra nueva
    }

    public static int sacarPrecioMasDeUnKg(ObraDeArte obra) {
        if(obra.getPeso() > 1){
            return 100;
        }
        return 20;
    }

    public static int sacarPrecioMasDeDosMetros(ObraDeArte obra) {
        if(obra.getAltura() > 2){
            return 100;
        }
        return 20;
    }

    public static int sacarPrecioMasDeDosPiezas(ObraDeArte obra) {
        if (obra.getNumeroPiezas() > 2){
            return 10 * obra.getNumeroPiezas();
        }
        return 0;
    }

    public static double sacarComisionGaleria(ObraDeArte obra) {
        return obra.getPrecio() * 0.25;
    }

    public static double sacarPrecioVenta(ObraDeArte obra){
        double precioVenta = obra.getPrecio() + sacarComisionGaleria(obra) + sacarPrecioMasDeDosMetros(obra)
        + sacarPrecioMasDeUnKg(obra) + sacarPrecioMasDeDosPiezas(obra); 
        if(obra instanceof Pintura){
            return (precioVenta * 0.1);
        }
        else{
            precioVenta -= (precioVenta * 0.2) + 50;
            return precioVenta;
        }
    }

    public static double sacarPrecioFinal(ObraDeArte obra) {

        return sacarPrecioVenta(obra) * 0.99; // transformacion a dolares
        
    }

}
