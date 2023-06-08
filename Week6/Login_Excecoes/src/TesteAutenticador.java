import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteAutenticador {

	@Test
	void loginComSucesso() throws LoginException {
		Autenticador a = new Autenticador();
		Usuario u = a.logar("guerra", "senhadoguerra");
		assertEquals("guerra", u.getLogin());
	}
	
	/* Junit4
	@Test(expected= LoginException.class)
	void loginFalho() throws LoginException {
		Autenticador a = new Autenticador();
		Usuario u = a.logar("guerra", "senhaerradadoguerra");
	}
	*/
	
	@Test
	void loginFalho() {
        Autenticador a = new Autenticador();
        assertThrows(LoginException.class, () -> {
            Usuario u = a.logar("guerra", "senhaerradadoguerra");
        });
    }
	
	
	@Test
	void informacaoDoErro() {
		Autenticador a = new Autenticador();
		try {
			Usuario u = a.logar("guerra", "senhaerradadoguerra"); //se a senha fosse correta iria falhar por causa do fail()
			fail();
		} catch (LoginException e) {
			assertEquals("guerra", e.getLogin()); //a senha deu erro, jogou pra essa excecao, e agora verifica se o login estava certo
		}
	}
	

}
