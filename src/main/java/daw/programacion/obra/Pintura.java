package daw.programacion.obra;

public class Pintura extends ObraDeArte {
    private String tecnica;

    public Pintura(int id, String tipo, String nombre, String autor, double precio, double altura, double peso,
            int numeroPiezas, String descripcion, String tecnica) {
        super(id, tipo, nombre, autor, precio, altura, peso, numeroPiezas, descripcion);
        this.tecnica = tecnica;
    }

    

}
