import java.util.Random;

public class MecanicaDoJogoPadrao implements MecanicaDoJogo {
    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private String palavraCorreta;
    private int pontuacao;
    private int maxTentativas;
    private int tentativas;

    public MecanicaDoJogoPadrao(BancoDePalavras bancoDePalavras, Embaralhador embaralhador) {
        this.bancoDePalavras = bancoDePalavras;
        this.embaralhador = embaralhador;
        this.pontuacao = 0;
        this.maxTentativas = 3;
        this.tentativas = 0;
        selecionarNovaPalavra();
    }

    private void selecionarNovaPalavra() {
        this.palavraCorreta = bancoDePalavras.getPalavraAleatoria();
    }

    @Override
    public String getPalavraEmbaralhada() {
        return embaralhador.embaralhar(palavraCorreta);
    }

    @Override
    public boolean tentarAcertar(String resposta) {
        if (resposta.equalsIgnoreCase(palavraCorreta)) {
            pontuacao++;
            selecionarNovaPalavra();
            return true;
        } else {
            tentativas++;
            selecionarNovaPalavra();
            return false;
        }
    }

    @Override
    public boolean isFimDeJogo() {
        return tentativas >= maxTentativas;
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }
}
