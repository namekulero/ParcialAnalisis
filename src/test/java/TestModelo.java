import com.todo.modelo.Modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class TestModelo {
    @BeforeEach
    void setUpClass() {
        Modelo.agregarLibro("prueba", "autor", "categoria");
    }
    
    @Test
    void testAgregarLibro() {
        assertEquals(true, Modelo.buscarLibro("prueba"));
    }
    
    @Test
    void testReservarLibro() {
        Modelo.reservarLibro("prueba");
        assertEquals(false, Modelo.buscarDisponibilidad("prueba"));
    }
    
    @Test
    void testDevolverLibro() {
        Modelo.devolverLibro("prueba");
        assertEquals(true, Modelo.buscarDisponibilidad("prueba"));
    }
    
    @Test
    void testEliminarLibro() {
        Modelo.eliminarLibro("prueba");
        assertEquals(false, Modelo.buscarLibro("prueba"));
    }
}
