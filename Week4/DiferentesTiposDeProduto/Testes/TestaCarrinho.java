import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestaCarrinho {
	
	private CarrinhoDeCompras carrinho;
	
	@Before
	public void limpaCarrinho()
	{
		carrinho = new CarrinhoDeCompras();
		carrinho.limpaCarrinho();
	}
	
	@Test
	public void testaAddNoCarrinho()
	{
		Produto p1 = new Produto(12, "Calça Jeans", 15);
		Produto p2 = new Produto(05, "Bone", 5);
		carrinho.adicionaProduto(p1, 3);
		carrinho.adicionaProduto(p2, 1);
		assertEquals(CarrinhoDeCompras.getQuantidadeNoCarrinho(), 4);	
	}
	
	@Test
	public void testaRemoveDoCarrinho()
	{
		Produto p1 = new Produto(12, "Calça Jeans", 15);
		carrinho.adicionaProduto(p1, 3);
		carrinho.removeProduto(p1, 1);
		assertEquals(CarrinhoDeCompras.getQuantidadeNoCarrinho(), 2);	
	}
	
	@Test
	public void testaPrecoTotalDoCarrinho()
	{
		Produto p1 = new Produto(05, "Bone", 5);
		Produto p2 = new Produto(33, "Sapato", 10);
		Produto p3 = new Produto(12, "Calça Jeans", 15);
		
		carrinho.adicionaProduto(p1, 3);
		carrinho.adicionaProduto(p2, 2);
		carrinho.adicionaProduto(p3, 1);
		
		assertEquals(carrinho.getPrecoTotalCarrinho(), 50.0, 0.01);	
	}

}