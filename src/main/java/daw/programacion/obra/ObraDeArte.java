package daw.programacion.obra;

public class ObraDeArte {

    private int id;
    private String nombre;
    private String autor;
    private double precio;
    private double altura;
    private double peso;
    private int numeroPiezas;
    private String descripcion;

    public ObraDeArte(int id, String nombre, String autor, double precio, double altura, double peso,
            int numeroPiezas, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.altura = altura;
        this.peso = peso;
        this.numeroPiezas = numeroPiezas;
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecio() {
        return precio;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String toString() {
        return "ObraDeArte [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", precio=" + precio + ", altura="
                + altura + ", peso=" + peso + ", numeroPiezas=" + numeroPiezas + ", descripcion=" + descripcion + "]";
    }

    

}
