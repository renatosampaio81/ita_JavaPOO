// Variáveis de Instância (dinâmicas) VS Variáveis Estáticas

public class Somador {
	
	String nome;
	int valorInstancia = 0; //cada objeto terá a sua.
	static int valorEstatica = 0; //fica na classe e será compartilhada por todos os objetos.

	void somar() {
		valorInstancia++;
		valorEstatica++;
	}
	
	void imprimir() {
		System.out.println("O somador "+nome+": instancia="+valorInstancia+" e estatica="+valorEstatica);
	}
	
}
