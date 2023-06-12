
public class FabricaMecanicaDoJogo {
    public MecanicaDoJogo getMecanicaDoJogo(BancoDePalavras bancoDePalavras, Embaralhador embaralhador, String tipoMecanica) {
        if (tipoMecanica.equalsIgnoreCase("limite_tempo")) {
            return new MecanicaDoJogoLimiteTempo(bancoDePalavras, embaralhador, 30); // 30 segundos de limite de tempo
        } else {
            return new MecanicaDoJogoPadrao(bancoDePalavras, embaralhador);
        }
    }
}

