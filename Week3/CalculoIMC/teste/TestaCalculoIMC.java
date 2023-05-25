import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestaCalculoIMC {
	
	@Test
    void baixoPesoMuitoGrave() {
        Paciente p1 = new Paciente(40.0, 1.70);
        assertEquals(13.84, p1.calcularIMC(), 0.01);
        assertEquals("Baixo peso muito grave = 13.84", p1.diagnostico());
    }
	
	@Test
    void baixoPesoGrave() {
        Paciente p1 = new Paciente(47.0, 1.70);
        assertEquals(16.26, p1.calcularIMC(), 0.01);
        assertEquals("Baixo peso grave = 16.26", p1.diagnostico());
    }
	
	@Test
    void baixoPeso() {
        Paciente p1 = new Paciente(52.0, 1.70);
        assertEquals(17.99, p1.calcularIMC(), 0.01);
        assertEquals("Baixo peso = 17.99", p1.diagnostico());
    }
	
	@Test
    void pesoNormal() {
        Paciente p1 = new Paciente(70.0, 1.70);
        assertEquals(24.22, p1.calcularIMC(), 0.01);
        assertEquals("Peso normal = 24.22", p1.diagnostico());
    }
	
	@Test
    void sobrepeso() {
        Paciente p1 = new Paciente(80.0, 1.70);
        assertEquals(27.68, p1.calcularIMC(), 0.01);
        assertEquals("Sobrepeso = 27.68", p1.diagnostico());
    }
	
	@Test
    void obesidadeGrauI() {
        Paciente p1 = new Paciente(89.0, 1.70);
        assertEquals(30.80, p1.calcularIMC(), 0.01);
        assertEquals("Obesidade grau I = 30.80", p1.diagnostico());
    }
	
	@Test
    void obesidadeGrauII() {
        Paciente p1 = new Paciente(105.0, 1.70);
        assertEquals(36.33, p1.calcularIMC(), 0.01);
        assertEquals("Obesidade grau II = 36.33", p1.diagnostico());
    }
	
	@Test
    void obesidadeGrauIII() {
        Paciente p1 = new Paciente(125.0, 1.70);
        assertEquals(43.25, p1.calcularIMC(), 0.01);
        assertEquals("Obesidade grau III (obesidade mórbida) = 43.25", p1.diagnostico());
    }
	
}