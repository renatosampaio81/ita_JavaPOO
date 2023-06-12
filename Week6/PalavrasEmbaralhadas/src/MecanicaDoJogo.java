
public interface MecanicaDoJogo {
    String getPalavraEmbaralhada();
    boolean tentarAcertar(String palavra);
    boolean isFimDeJogo();
    int getPontuacao();
}
