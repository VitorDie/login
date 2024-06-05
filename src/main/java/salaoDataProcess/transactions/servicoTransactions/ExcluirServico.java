package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;

public class ExcluirServico extends ServicoTransaction {

    private final Integer id;

    protected ExcluirServico(Integer id, ServicoDB database) {
        super(database);
        this.id = id;
    }

    @Override
    public void execute() {
        database.delete(id);
    }
}
