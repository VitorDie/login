package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;
import salaoDataProcess.modeloDeDados.Profissional;

public class AdicionarProfissional extends ProfissionalTransaction {
    private String nome;
    private Integer id;

    protected AdicionarProfissional(Integer id, String nome, ProfissionalDB database) {
        super(database);
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void execute() {
        database.create(id, new Profissional(nome));
    }
}
