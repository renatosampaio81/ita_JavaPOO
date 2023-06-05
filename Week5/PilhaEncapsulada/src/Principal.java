
public class Principal {
	
	public static void main(String[] args) {
		Pilha p = new Pilha(10);
		p.empilhar("Eduardo");
		p.empilhar("Maria");
		p.empilhar("Jose");
		System.out.println(p.topo());
		System.out.println(p.tamanho());
		
		//qualquer mudanća que eu fizer nesse array que eu acabei de criar vai alterar lá no array de Pilha p, que deveria ser privado. Alternativa é retornar cópia do array
		Object[] arrayElementos = p.getElementos();
		arrayElementos[1] = "OUTRO";
		//com as mudanćas feitas no getElementos(), agora posso alterar esse novo array que o original não será alterado.
		
		//Desempilhando
		System.out.println("--------------");
		System.out.println(p.desempilhar());
		System.out.println(p.topo().toString().toUpperCase());
		System.out.println(p.tamanho());
		
		
	}

}
