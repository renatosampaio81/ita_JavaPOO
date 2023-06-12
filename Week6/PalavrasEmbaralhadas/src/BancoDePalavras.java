import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {
    private List<String> palavras;

    public BancoDePalavras() {
        palavras = lerPalavrasDoArquivo();
    }

    private List<String> lerPalavrasDoArquivo() {
        List<String> listaPalavras = new ArrayList<>();
        try {
            Path path = Paths.get("src/main/resources/palavras.txt");
            List<String> linhas = Files.readAllLines(path);
            for (String linha : linhas) {
                String palavra = linha.trim();
                if (!palavra.isEmpty()) {
                    listaPalavras.add(palavra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPalavras;
    }

    public String getPalavraAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }
}
