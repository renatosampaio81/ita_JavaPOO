import org.junit.Test;
import static org.junit.Assert.*;

public class FabricaEmbaralhadoresTest {

    @Test
    public void testGetEmbaralhadorAleatorio() {
        FabricaEmbaralhadores fabrica = new FabricaEmbaralhadores();
        Embaralhador embaralhador = fabrica.getEmbaralhadorAleatorio();
        
        assertNotNull(embaralhador);
        assertTrue(embaralhador instanceof EmbaralhadorAleatorio || embaralhador instanceof EmbaralhadorInverso);
    }
}
