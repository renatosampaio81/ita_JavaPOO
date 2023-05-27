
public class DoMeio extends PaiDeTodos {

	public DoMeio() {
		super("parametro"); //se voce nao colocar essa chamada ela ocorrerá de qualquer forma, sempre o construtor da classe acima é chamado antes do construtor da própria classe
		System.out.println("Construtor DoMeio");
	}

}
