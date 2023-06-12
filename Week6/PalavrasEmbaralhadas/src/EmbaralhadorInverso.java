
public class EmbaralhadorInverso implements Embaralhador {
    @Override
    public String embaralhar(String palavra) {
        StringBuilder sb = new StringBuilder(palavra);
        return sb.reverse().toString();
    }

    @Override
    public int getDificuldade() {
        return 2;
    }
}

