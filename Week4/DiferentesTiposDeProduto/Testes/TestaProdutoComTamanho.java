import static org.junit.Assert.*;
import org.junit.Test;

public class TestaProdutoComTamanho {

	@Test
	public void testaEquals() {

			Produto p1 = new ProdutoComTamanho(1, "Bone", 20, 15);
			Produto p2 = new ProdutoComTamanho(1, "Calça", 22, 15);
			assertEquals(p1.equals(p1), p1.equals(p2));
			
			Produto p3 = new ProdutoComTamanho(2, "Bone", 20, 5);
			Produto p4 = new ProdutoComTamanho(3, "Calça", 22, 15);
			assertNotEquals(p3.equals(p3), p3.equals(p4));
			
	}

	@Test
	public void testaHashCode()
	{
		Produto p5 = new ProdutoComTamanho(11, "Capacete", 25, 5);
		Produto p6 = new ProdutoComTamanho(11, "Bone", 20, 5);
		assertEquals(p5.hashCode(), p6.hashCode());
		
		Produto p7 = new ProdutoComTamanho(22, "Capacete", 25, 5);
		Produto p8 = new ProdutoComTamanho(33, "Bone", 20, 15);
		assertNotEquals(p7.hashCode(), p8.hashCode());
		
	}


}