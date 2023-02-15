package daw.programacion.obra;

public class Escultura extends ObraDeArte {
    private String material;

    public String getMaterial() {
        return material;
    }

    public Escultura(int id, String nombre, String autor, double precio, double altura, double peso, int numeroPiezas,
            String descripcion, String material) {
        super(id, nombre, autor, precio, altura, peso, numeroPiezas, descripcion);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    

}
