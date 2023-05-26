import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteContaEspecial extends TesteContaCorrente {
	
	@BeforeEach
	public void inicializaConta() {
		cc = new ContaEspecial(100);
		cc.depositar(200);
	}

	@Test
	void saqueMaiorQueSaldo() {
		int valorSacado = cc.sacar(350);
		assertEquals(cc.saldo, 200);
		assertEquals(valorSacado, 0);
	}
	
	@Test
	void saqueUsandoLimite() {
		int valorSacado = cc.sacar(250);
		assertEquals(cc.saldo, -50);
		assertEquals(valorSacado, 250);
	}
	
}
