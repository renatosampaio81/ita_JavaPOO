import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {
	
	private Map<Produto, Integer> carrinho = new HashMap<>();
	private static int quantidadeNoCarrinho;
	private static double total= 0;

	
	public void adicionaProduto(Produto p, int quantidade)
	{
		if (carrinho.containsKey(p))
		{
			carrinho.put(p, quantidade+=quantidade);
		}
		else carrinho.put(p, quantidade);
		quantidadeNoCarrinho += quantidade;
	}


	public void removeProduto(Produto p, int quantidade)
	{
		if (carrinho.containsKey(p))
		{
			carrinho.remove(p);
			quantidadeNoCarrinho -= quantidade;
		}
	}
	
	public void limpaCarrinho()
	{
		quantidadeNoCarrinho = 0;
		total = 0;
	}
	
	public double getPrecoTotalCarrinho()
	{
		total = 0;
	    for (Map.Entry<Produto, Integer> entry : carrinho.entrySet())
	    {
	        Produto produto = entry.getKey();
	        int quantidade = entry.getValue();
	        total += produto.getPreco() * quantidade;
		}
		return total;
	}
	
	public HashMap<Produto, Integer> getCarrinho() {
		return (HashMap<Produto, Integer>) carrinho;
	}

	public void setCarrinho(HashMap<Produto, Integer> carrinho) {
		this.carrinho = carrinho;
	}

	public static int getQuantidadeNoCarrinho() {
		return quantidadeNoCarrinho;
	}

	public static void setQuantidadeNoCarrinho(int quantidadeNoCarrinho) {
		CarrinhoDeCompras.quantidadeNoCarrinho = quantidadeNoCarrinho;
	}	

	
}