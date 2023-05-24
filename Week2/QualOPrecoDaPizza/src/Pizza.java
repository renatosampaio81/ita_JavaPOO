import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {

    private static final double PRECO_PIZZA_1 = 15;
    private static final double PRECO_PIZZA_2 = 20;
    private static final double PRECO_PIZZA_3 = 23;

    private double preco;
    private List<String> ingredientes = new ArrayList<>();
    private static Map<String, Integer> mapaIngredientes = new HashMap<>();
    private static int totalIngredientes = 0;
    

    public List<String> getIngrediente() {
        return new ArrayList<>(ingredientes); //retorna cópia de lista de ingredientes
    }

    public static Map<String, Integer> getListaIngredientes() {
        return new HashMap<>(mapaIngredientes);
    }

    public void adicionaIngrediente(String ingrediente) {
        ingredientes.add(ingrediente);
        contabilizaIngrediente(ingrediente);
    }

    public double getPreco() {
        int numIngredientes = ingredientes.size();
        if (numIngredientes <= 2) {
            preco = PRECO_PIZZA_1;
        } else if (numIngredientes <= 5) {
            preco = PRECO_PIZZA_2;
        } else {
            preco = PRECO_PIZZA_3;
        }
        return preco;
    }

    private static void contabilizaIngrediente(String ingrediente) {
        if (mapaIngredientes.containsKey(ingrediente)) {
            int value = mapaIngredientes.get(ingrediente);
            mapaIngredientes.put(ingrediente, value + 1);
        } else {
            mapaIngredientes.put(ingrediente, 1);
        }
        totalIngredientes++;
    }

    public static int getTotalIngredientes() {
        return totalIngredientes;
    }
}