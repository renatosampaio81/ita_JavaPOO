import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestePizza {

    @BeforeEach
    public void limparRegPizza() {
        Pizza.zeraIngredientes();
    }

    @Test
    public void teste() {
        Pizza pedidoPizza1 = new Pizza();

        pedidoPizza1.adicionaIngrediente("Tomate");
        pedidoPizza1.adicionaIngrediente("Queijo");
        pedidoPizza1.adicionaIngrediente("Presunto");
        pedidoPizza1.adicionaIngrediente("Orégano");

        assertEquals(4, pedidoPizza1.getIngrediente().size());
    }

    @Test
    public void testeIngredientes() {
        Pizza pedidoPizza1 = new Pizza();

        pedidoPizza1.adicionaIngrediente("Tomate");
        pedidoPizza1.adicionaIngrediente("Queijo");
        pedidoPizza1.adicionaIngrediente("Presunto");
        pedidoPizza1.adicionaIngrediente("Orégano");

        ArrayList<String> ingredientes = new ArrayList<>(pedidoPizza1.getIngrediente());

        assertEquals(ingredientes, pedidoPizza1.getIngrediente());
    }
    
}