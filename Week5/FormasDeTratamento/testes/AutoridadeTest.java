import org.junit.Test;
import static org.junit.Assert.*;

public class AutoridadeTest {

    @Test
    public void testGetTratamentoComFormatadorInformal() {
        FormatadorNome formatador = new Informal();
        Autoridade autoridade = new Autoridade("João", "Silva", formatador);
        String tratamento = autoridade.getTratamento();
        assertEquals("João", tratamento);
    }

    @Test
    public void testGetTratamentoComFormatadorRespeitosoMasculino() {
        FormatadorNome formatador = new Respeitoso("masculino");
        Autoridade autoridade = new Autoridade("João", "Silva", formatador);
        String tratamento = autoridade.getTratamento();
        assertEquals("Sr. Silva", tratamento);
    }

    @Test
    public void testGetTratamentoComFormatadorRespeitosoFeminino() {
        FormatadorNome formatador = new Respeitoso("feminino");
        Autoridade autoridade = new Autoridade("Maria", "Santos", formatador);
        String tratamento = autoridade.getTratamento();
        assertEquals("Sra. Santos", tratamento);
    }

    @Test
    public void testGetTratamentoComFormatadorComTitulo() {
        FormatadorNome formatador = new ComTitulo("Mestre");
        Autoridade autoridade = new Autoridade("Pedro", "Cabral", formatador);
        String tratamento = autoridade.getTratamento();
        assertEquals("Mestre Pedro Cabral", tratamento);
    }
}
