import java.util.HashMap;
import java.util.Map;

public class Corrida {
	
	private int pista;
	private Map<CarroDeCorrida, Integer> carros = new HashMap<>(); //no Map o carro é a primeira cha e a distancia percorrida a segunda chave
	

	public Corrida(int tamanho) {
		pista = tamanho;
	}
	
	public void adicionaCarro(CarroDeCorrida carro) {
		carros.put(carro,  0);
	}
	
	private boolean terminou() {
		for(Integer valor : carros.values()) { //varre os valores das chaves do Map carros e verifica se é maior ou igual a distancia total da pista
			if(valor >= pista)
				return true;
		}
		return false;
	}
	
	public void umDoisTresEJa() {
		while(!terminou()) { //verifica se a corrida já terminou, se nao terminou dá mais uma volta
			for(CarroDeCorrida carro : carros.keySet()) { //varre as chaves do Map carros, sabendo que esses valores sao objetos carro
				carro.acelerar();
				int distancia = carros.get(carro); //busca o valor da chave do carro que esta no loop e atribui a distancia
				distancia += carro.getVelocidade(); //pega a velocidade que o carro está nessa volta e soma a distancia percorrida
				carros.put(carro,  distancia); //atualiza a distancia percorrida pro carro que está no loop
			}
		}
		for(CarroDeCorrida carro : carros.keySet() ) { //com a corrida terminada, mostra o resultado de cada carro
			System.out.println(carro.getNome() + " - " + carros.get(carro));
		}
		
	}

}
