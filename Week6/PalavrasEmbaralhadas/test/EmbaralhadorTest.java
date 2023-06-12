import org.junit.Test;
import static org.junit.Assert.*;

public class EmbaralhadorTest {

    @Test
    public void testEmbaralhar() {
        Embaralhador embaralhador = new Embaralhador() {
            @Override
            public String embaralhar(String palavra) {
                return "embaralhado";
            }
            
            @Override
            public int getDificuldade() {
                return 3;
            }
        };
        
        String palavra = "teste";
        String embaralhada = embaralhador.embaralhar(palavra);
        
        assertEquals("embaralhado", embaralhada);
    }
    
    @Test
    public void testGetDificuldade() {
        Embaralhador embaralhador = new Embaralhador() {
            @Override
            public String embaralhar(String palavra) {
                return "embaralhado";
            }
            
            @Override
            public int getDificuldade() {
                return 3;
            }
        };
        
        int dificuldade = embaralhador.getDificuldade();
        
        assertEquals(3, dificuldade);
    }
}

