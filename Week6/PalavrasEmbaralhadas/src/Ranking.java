import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ranking {
    private static final int MAX_RANKING_SIZE = 10;

    private List<Jogador> jogadoresPadrao;
    private List<Jogador> jogadoresLimiteTempo;

    public Ranking() {
        jogadoresPadrao = carregarRankingPadrao();
        jogadoresLimiteTempo = carregarRankingLimiteTempo();
    }

    public void adicionarJogador(Jogador jogador) {
        if (jogador != null && jogador.getPontuacao() > 0) {
            if (isModoPadrao(jogador.getTipoMecanica())) {
                adicionarJogadorNoRanking(jogador, jogadoresPadrao);
                salvarRankingPadrao();
            } else {
                adicionarJogadorNoRanking(jogador, jogadoresLimiteTempo);
                salvarRankingLimiteTempo();
            }
        }
    }

    private boolean isModoPadrao(String tipoMecanica) {
        return tipoMecanica.equals("padrao");
    }

    private void adicionarJogadorNoRanking(Jogador jogador, List<Jogador> ranking) {
        ranking.add(jogador);
        ordenarRanking(ranking);
        if (ranking.size() > MAX_RANKING_SIZE) {
            ranking.remove(ranking.size() - 1);
        }
    }

    private void ordenarRanking(List<Jogador> ranking) {
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    private List<Jogador> carregarRankingPadrao() {
        return carregarRanking("src/main/resources/ranking_padrao.txt");
    }

    private List<Jogador> carregarRankingLimiteTempo() {
        return carregarRanking("src/main/resources/ranking_limite_tempo.txt");
    }

    private List<Jogador> carregarRanking(String arquivo) {
        try {
            return Files.lines(Paths.get(arquivo))
                    .map(this::criarJogadorAPartirDaLinha)
                    .limit(MAX_RANKING_SIZE)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Erro ao ler o ranking.");
            return new ArrayList<>();
        }
    }

    private Jogador criarJogadorAPartirDaLinha(String linha) {
        String[] partes = linha.split(":");
        String nome = partes[0].trim();
        int pontuacao = Integer.parseInt(partes[1].trim());
        return new Jogador(nome, pontuacao);
    }

    private void salvarRankingPadrao() {
        salvarRanking("src/main/resources/ranking_padrao.txt", jogadoresPadrao);
    }

    private void salvarRankingLimiteTempo() {
        salvarRanking("src/main/resources/ranking_limite_tempo.txt", jogadoresLimiteTempo);
    }

    private void salvarRanking(String arquivo, List<Jogador> ranking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador jogador = ranking.get(i);
                String linha = formatarLinhaRanking(i + 1, jogador.getNome(), jogador.getPontuacao());
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking.");
        }
    }

    private String formatarLinhaRanking(int posicao, String nome, int pontuacao) {
        return String.format("#%d - %s - %02d pontos", posicao, nome, pontuacao);
    }

    public void exibirRankingPadrao() {
        exibirRanking(jogadoresPadrao);
    }

    public void exibirRankingLimiteTempo() {
        exibirRanking(jogadoresLimiteTempo);
    }

    private void exibirRanking(List<Jogador> ranking) {
        if (ranking.isEmpty()) {
            System.out.println("O ranking está vazio.");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador jogador = ranking.get(i);
                String linha = formatarLinhaRanking(i + 1, jogador.getNome(), jogador.getPontuacao());
                System.out.println(linha);
            }
        }
    }
}

