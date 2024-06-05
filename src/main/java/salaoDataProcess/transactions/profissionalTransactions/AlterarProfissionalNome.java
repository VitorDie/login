package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;
import salaoDataProcess.modeloDeDados.Profissional;

public class AlterarProfissionalNome extends AlterarProfissional{
    private Integer id;
    private String nome;
    protected AlterarProfissionalNome(Integer id, String nome, ProfissionalDB database) {
        super(database);
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void execute() {
        Profissional p = database.read(id);
        p.setNome(nome);
        database.update(id, p);
    }
}
