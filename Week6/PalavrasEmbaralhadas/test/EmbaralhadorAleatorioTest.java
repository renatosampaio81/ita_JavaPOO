import org.junit.Test;
import static org.junit.Assert.*;

public class EmbaralhadorAleatorioTest {

    @Test
    public void testEmbaralhar() {
        EmbaralhadorAleatorio embaralhador = new EmbaralhadorAleatorio();
        String palavra = "teste";
        String embaralhada = embaralhador.embaralhar(palavra);
        
        assertNotEquals("teste", embaralhada);
    }
    
    @Test
    public void testGetDificuldade() {
        EmbaralhadorAleatorio embaralhador = new EmbaralhadorAleatorio();
        int dificuldade = embaralhador.getDificuldade();
        
        assertTrue(dificuldade >= 1 && dificuldade <= 5);
    }
}
