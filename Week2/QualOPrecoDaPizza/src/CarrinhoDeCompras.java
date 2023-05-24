import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Pizza> pizzas = new ArrayList<>();
	private double precoTotal = 0;
	
	public void addPizza(Pizza pizza) {
		if (!pizza.getIngrediente().isEmpty()) { // Se a pizza não está sem ingredientes
			pizzas.add(pizza);
		}
	}
	
	public int getTotalPizzas() {
		return pizzas.size();
	}
	
	public double getPrecoTotal() {
		for (Pizza pizza : pizzas) {
			precoTotal += pizza.getPreco();
		}
		return precoTotal;
	}

}