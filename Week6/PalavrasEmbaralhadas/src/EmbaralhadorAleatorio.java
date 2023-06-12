
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmbaralhadorAleatorio implements Embaralhador {
    @Override
    public String embaralhar(String palavra) {
        List<Character> letras = new ArrayList<>();
        for (char c : palavra.toCharArray()) {
            letras.add(c);
        }

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (!letras.isEmpty()) {
            int indice = random.nextInt(letras.size());
            sb.append(letras.remove(indice));
        }

        return sb.toString();
    }

    @Override
    public int getDificuldade() {
        return 5;
    }
}

