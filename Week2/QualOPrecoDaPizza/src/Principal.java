public class Principal {

	public static void main(String[] args) {

		Pizza p1 = criarPizza("Calabresa", "Mucarela", "Milho");
		Pizza p2 = criarPizza("Frango", "Catupiry", "Mucarela", "Cebola", "Borda Recheada", "Ferradura");
		Pizza p3 = criarPizza("Palmito", "Frango", "Cheddar");

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

		carrinho.addPizza(p1);
		carrinho.addPizza(p2);
		carrinho.addPizza(p3);

		System.out.println("Total de pizzas no carrinho: " + carrinho.getTotalPizzas());
		System.out.println("Valor total da compra: " + carrinho.getPrecoTotal());

		System.out.println("Lista de ingredientes utilizados: \n" + Pizza.getListaIngredientes());

	}

	private static Pizza criarPizza(String... ingredientes) {
		Pizza pizza = new Pizza();
		for (String ingrediente : ingredientes) {
			pizza.adicionaIngrediente(ingrediente);
		}
		return pizza;
	}

}