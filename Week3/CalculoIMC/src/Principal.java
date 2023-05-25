
public class Principal {

	public static void main(String[] args) {
		Paciente p1 = new Paciente(80.0, 1.83);
		System.out.println(p1.diagnostico());

		Paciente p2 = new Paciente(90.0, 1.86);
		System.out.println(p2.diagnostico());

		Paciente p3 = new Paciente(110.0, 1.89);
		System.out.println(p3.diagnostico());
	}
}
