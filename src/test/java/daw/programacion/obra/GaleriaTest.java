package daw.programacion.obra;

import daw.programacion.obra.ObraDeArte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GaleriaTest {

    private Pintura pinturaTesteo;
    private Escultura esculturaTesteo;

    @BeforeEach
    void crearObras() {
        pinturaTesteo = new Pintura(99, "Nombre", "Autor", 99, 99, 99, 99, "Descripcion", "Tecnica");
        esculturaTesteo = new Escultura(99, "Nombre", "Autor", 99, 99, 99, 99, "Descripcion", "Material");
    }

    @AfterEach
    void borrarObras(){
        pinturaTesteo = null;
        esculturaTesteo = null;
    }

    @Test
    public void testAñadirobra() {
        Pintura expected = pinturaTesteo;
        Galeria.añadirobra(expected);
        assertEquals(expected, Galeria.getObras()[Galeria.getObras().length - 1]);
    }

    @Test
    public void testSacarComisionGaleria() {
        double expected = pinturaTesteo.getPrecio() * 0.25;
        assertEquals(expected, Galeria.sacarComisionGaleria(pinturaTesteo));
    }

    @Test
    public void testSacarPrecioFinal() {
        double expected = 130.06125;
        assertEquals(expected, Galeria.sacarPrecioFinal(pinturaTesteo));
    }

    @Test
    public void testSacarPrecioMasDeDosMetros() {
        double expected = 100;
        assertEquals(expected, Galeria.sacarPrecioMasDeDosMetros(esculturaTesteo));
    }

    @Test
    public void testSacarPrecioMasDeDosPiezas() {
        double expected = 990;
        assertEquals(expected, Galeria.sacarPrecioMasDeDosPiezas(esculturaTesteo));
    }

    @Test
    public void testSacarPrecioMasDeUnKg() {
        double expected = 100;
        assertEquals(expected, Galeria.sacarPrecioMasDeUnKg(esculturaTesteo));
    }

    @Test
    public void testSacarPrecioVenta() {
        double expected = Galeria.sacarComisionGaleria(esculturaTesteo)
                + Galeria.sacarPrecioMasDeDosMetros(esculturaTesteo) + Galeria.sacarPrecioMasDeUnKg(esculturaTesteo)
                + Galeria.sacarPrecioMasDeDosPiezas(esculturaTesteo) + esculturaTesteo.getPrecio();
        expected -= (expected * 0.2) + 50;

        assertEquals(expected, Galeria.sacarPrecioVenta(esculturaTesteo));
    }

    @Test
    public void testCrearObra(){
        int id = 6;
        String tipo = "Pintura";
        String nombre = "Prueba";
        String autor = "Autor";
        double precio = 1;
        double altura = 2;
        double peso = 3;
        double piezas = 4;
        String descripcion = "Descripcion";
        String tecnica = "Tecnica";
        Pintura expected = new Pintura(id, nombre, autor, precio, altura, peso, id, descripcion, tecnica);
        Galeria.crearObra(id, tipo, nombre, autor, precio, altura, peso, id, descripcion, tecnica);
        // ESTE TEST DA UN ERROR POR ALGUNA RAZÓN A PESAR DE SER LA MISMA OBRA.
        assertEquals(expected, Galeria.getObras()[Galeria.getObras().length-1]);
    }


}
