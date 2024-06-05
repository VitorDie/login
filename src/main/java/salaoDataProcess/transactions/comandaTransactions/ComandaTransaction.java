package salaoDataProcess.transactions.comandaTransactions;

import salaoDataOutput.ComandaDB;
import salaoDataProcess.transactions.Transaction;

public abstract class ComandaTransaction implements Transaction {
    protected final ComandaDB database;

    protected ComandaTransaction(ComandaDB database) {
        this.database = database;
    }
}
