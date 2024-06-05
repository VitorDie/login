package salaoDataProcess.modeloDeDados;

public class Progressiva extends Servico{

    public Progressiva(Double valor) {
        super(nomePadrao(), valor);
    }

    public static String nomePadrao() {
        return "Progressiva";
    }

}
