package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;
import salaoDataProcess.transactions.Transaction;

public abstract class AtendimentoTransaction implements Transaction {
    protected final AtendimentoDB database;

    public AtendimentoTransaction(AtendimentoDB database) {
        this.database = database;
    }
}
