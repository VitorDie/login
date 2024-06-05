package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.transactions.Transaction;

public abstract class ServicoTransaction implements Transaction {
    protected final ServicoDB database;

    protected ServicoTransaction(ServicoDB database) {
        this.database = database;
    }
}
