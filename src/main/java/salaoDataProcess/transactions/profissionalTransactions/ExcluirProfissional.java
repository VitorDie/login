package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;

public class ExcluirProfissional extends ProfissionalTransaction {
    private Integer id;

    protected ExcluirProfissional(Integer id, ProfissionalDB database) {
        super(database);
        this.id = id;
    }

    @Override
    public void execute() {
        database.delete(id);
    }
}
