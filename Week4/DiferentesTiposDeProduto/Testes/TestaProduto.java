import static org.junit.Assert.*;
import org.junit.Test;

public class TestaProduto {

	@Test
	public void testaEquals() {
		Produto p1 = new Produto(2, "Camiseta", 30);
		Produto p2 = new Produto(2, "Calça", 32);
		assertEquals(p1.equals(p1), p1.equals(p2));
		
		Produto p3 = new Produto(1, "Camiseta", 30);
		Produto p4 = new Produto(3, "Calça", 32);
		assertNotEquals(p3.equals(p3), p3.equals(p4));
	}
	
	@Test
	public void testaHashCode()
	{
		Produto p5 = new Produto(22, "Camiseta", 30);
		Produto p6 = new Produto(22, "Blusa", 32);
		assertEquals(p5.hashCode(), p6.hashCode());
		
		Produto p7 = new Produto(11, "Camiseta", 30);
		Produto p8 = new Produto(33, "Blusa", 32);
		assertNotEquals(p7.hashCode(), p8.hashCode());
		
	}
	

}
