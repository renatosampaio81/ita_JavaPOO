import org.junit.Test;
import static org.junit.Assert.*;

public class EmbaralhadorInversoTest {

    @Test
    public void testEmbaralhar() {
        EmbaralhadorInverso embaralhador = new EmbaralhadorInverso();
        String palavra = "teste";
        String embaralhada = embaralhador.embaralhar(palavra);
        
        assertEquals("etset", embaralhada);
    }
    
    @Test
    public void testGetDificuldade() {
        EmbaralhadorInverso embaralhador = new EmbaralhadorInverso();
        int dificuldade = embaralhador.getDificuldade();
        
        assertEquals(2, dificuldade);
    }
}
