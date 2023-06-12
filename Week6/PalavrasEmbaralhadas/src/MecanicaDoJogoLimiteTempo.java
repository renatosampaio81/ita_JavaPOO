import java.util.Timer;
import java.util.TimerTask;
import java.awt.Robot;


public class MecanicaDoJogoLimiteTempo implements MecanicaDoJogo {
    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private Timer timer;
    private int tempoLimite;
    private boolean fimDeJogo;
    private int pontuacao;
    private String palavraAtual;

    public MecanicaDoJogoLimiteTempo(BancoDePalavras bancoDePalavras, Embaralhador embaralhador, int tempoLimite) {
        this.bancoDePalavras = bancoDePalavras;
        this.embaralhador = embaralhador;
        this.timer = new Timer();
        this.tempoLimite = tempoLimite;
        this.fimDeJogo = false;
        this.pontuacao = 0;
        this.palavraAtual = null;
        
        iniciarTimer();
    }

    @Override
    public String getPalavraEmbaralhada() {
        if (palavraAtual == null) {
            palavraAtual = bancoDePalavras.getPalavraAleatoria();
        }
        return embaralhador.embaralhar(palavraAtual);
    }

    @Override
    public boolean tentarAcertar(String resposta) {
        if (resposta.equalsIgnoreCase(palavraAtual)) {
            pontuacao++;
            palavraAtual = null;
            return true;
        }
        palavraAtual = null;
        return false;
    }

    @Override
    public boolean isFimDeJogo() {
        return fimDeJogo;
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }

    
    private void iniciarTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                fimDeJogo = true;
                //System.out.print(" [ TEMPO ESGOTADO !! ]");
                
                try {
                    Robot robot = new Robot();
                    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }, tempoLimite * 1000);
    }
 
}
