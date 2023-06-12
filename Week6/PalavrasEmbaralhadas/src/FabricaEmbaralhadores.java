
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {
    private List<Embaralhador> embaralhadores;

    public FabricaEmbaralhadores() {
        embaralhadores = new ArrayList<>();
        embaralhadores.add(new EmbaralhadorInverso());
        embaralhadores.add(new EmbaralhadorAleatorio());
    }

    public Embaralhador getEmbaralhadorAleatorio() {
        Random random = new Random();
        int indice = random.nextInt(embaralhadores.size());
        return embaralhadores.get(indice);
    }
}

