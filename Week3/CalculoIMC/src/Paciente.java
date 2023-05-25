import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Paciente {

    double quilos;
    double altura;
    private static final Locale LOCAL = new Locale("en", "US");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(LOCAL));

    public Paciente(double quilos, double altura) {
        this.quilos = quilos;
        this.altura = altura;
    }

    public double calcularIMC() {
        double imc = this.quilos / (this.altura * this.altura);
        imc = Double.parseDouble(DECIMAL_FORMAT.format(imc));
        return imc;
    }

    public String resultado(double imc) {
        return DECIMAL_FORMAT.format(imc);
    }

    public String diagnostico() {
        double imc = calcularIMC();

        if (imc > 0 && imc < 16.0)
            return "Baixo peso muito grave = " + resultado(imc);
        else if (imc >= 16.0 && imc <= 16.99)
            return "Baixo peso grave = " + resultado(imc);
        else if (imc >= 17.0 && imc <= 18.49)
            return "Baixo peso = " + resultado(imc);
        else if (imc >= 18.50 && imc <= 24.99)
            return "Peso normal = " + resultado(imc);
        else if (imc >= 25.0 && imc <= 29.99)
            return "Sobrepeso = " + resultado(imc);
        else if (imc >= 30.0 && imc <= 34.99)
            return "Obesidade grau I = " + resultado(imc);
        else if (imc >= 35.0 && imc <= 39.99)
            return "Obesidade grau II = " + resultado(imc);
        else
            return "Obesidade grau III (obesidade mórbida) = " + resultado(imc);
    }

}