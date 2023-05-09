import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Paciente {

	double quilos;
	double altura;
	private static final Locale LOCAL = new Locale("pt","BR");

	public Paciente(double quilos, double altura) {
		this.quilos = quilos;
		this.altura = altura;
	}

	public double calcularIMC() {
		double imc = this.quilos / (this.altura * this.altura);
		return imc;		
	}
	
	public String resultado(double imc) {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(LOCAL));
		return df.format(imc);
	}

	public void diagnostico() {		
		if (calcularIMC() > 0 && calcularIMC() < 16.0)
			System.out.println("Baixo peso muito grave = "+this.resultado(this.calcularIMC()));
		else if(calcularIMC() >= 16.0 && calcularIMC() <= 16.99)
			System.out.println("Baixo peso grave = "+this.resultado(this.calcularIMC()));
		else if(calcularIMC() >= 17.0 && calcularIMC() <= 18.49)
			System.out.println("Baixo peso = "+this.resultado(this.calcularIMC()));
		else if(calcularIMC() >= 18.50 && calcularIMC() <= 24.99)
			System.out.println("Peso normal = "+this.resultado(this.calcularIMC()));		
		else if(calcularIMC() >= 25.0 && calcularIMC() <= 29.99)
			System.out.println("Sobrepeso = "+this.resultado(this.calcularIMC()));
		else if(calcularIMC() >= 30.0 && calcularIMC() <= 34.99)
			System.out.println("Obesidade grau I = "+this.resultado(this.calcularIMC()));
		else if(calcularIMC() >= 35.0 && calcularIMC() <= 39.99)
			System.out.println("Obesidade grau II = "+this.resultado(this.calcularIMC()));
		else
			System.out.println("Obesidade grau III (obesidade mórbida) = "+this.resultado(this.calcularIMC()));
		
	}
	
}
