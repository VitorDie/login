package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;

public abstract class AlterarServico extends ServicoTransaction{
    protected AlterarServico(ServicoDB database) {
        super(database);
    }
}
