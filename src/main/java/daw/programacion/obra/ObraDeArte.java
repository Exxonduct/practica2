package daw.programacion.obra;

import java.util.Scanner;

public class ObraDeArte {

    private int id;
    private String nombre;
    private String autor;
    private double precio;
    private double altura;
    private double peso;
    private int numeroPiezas;
    private String descripcion;

    public static Pintura guernica = new Pintura(001, "Guernica", "P.Picasso", 1000, 5, 2, 5, "cuadro guerra civil", "Óleo");
    public static Pintura laVie = new Pintura(002, "La vie", "P.Picasso", 200, 1, 1, 1, "óleo", "Óleo");
    public static Pintura elSueño = new Pintura(003, "El Sueño", "P.Picasso", 300, 1.3, 1, 5, "óleo", "Óleo");
    public static Pintura retratoDeDoraMaar = new Pintura(004, "Retrato de Dora Maar", "P.Picasso", 400, 1, 0.8, 1, "óleo",
            "Óleo");
    static Escultura elPielRoja = new Escultura(005, "El piel roja", "U.Checa", 350, 1, 0.8, 1, "escultura", "null");

    private static ObraDeArte[] obras = {guernica, laVie, elSueño, retratoDeDoraMaar, elPielRoja};

    public static void crearObrasPrimeras() {


    }

    public String getTecnica(Pintura pintura) {
        return pintura.getTecnica();
    }

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

    public void printObras(Escultura[] esculturas, Pintura[] pinturas) {

    }

    public static void printObras() {
        System.out.println("");
        System.out.println("Esculturas: ");
        for (int i = 0; i < obras.length; i++) {
            System.out.print("ID: " + obras[i].getId());
            System.out.print(" Nombre: " + obras[i].getNombre());
            System.out.print(" Autor: " + obras[i].getAutor());
            System.out.print(" Precio: " + obras[i].getPrecio() + " euros");
            System.out.print(" Altura: " + obras[i].getAltura() + "m");
            System.out.print(" Peso: " + obras[i].getPeso() + "t");
            System.out.print(" Piezas: " + obras[i].getNumeroPiezas());
            System.out.print(" Descripción: " + obras[i].getDescripcion());
            System.out.println("");

        }
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

    public static void crearObra() {
        Scanner read = new Scanner(System.in);
        System.out.println("si");
        int si = read.nextInt();
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

}
