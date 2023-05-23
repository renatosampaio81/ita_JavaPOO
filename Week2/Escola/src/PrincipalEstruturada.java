
public class PrincipalEstruturada {

	public static void main(String[] args) {
		AlunoEstruturada guerra = new AlunoEstruturada();
		guerra.bim1 = 70;
		guerra.bim2 = 60;
		guerra.bim3 = 80;
		guerra.bim4 = 70;
		
		System.out.println(VerificadoraNotasEstruturada.mediaAluno(guerra));
		System.out.println(VerificadoraNotasEstruturada.passouDeAno(guerra));
	}

}
