package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;
import salaoDataProcess.transactions.Transaction;

public abstract class ProfissionalTransaction implements Transaction {
    protected final ProfissionalDB database;

    protected ProfissionalTransaction(ProfissionalDB database) {
        this.database = database;
    }
}
