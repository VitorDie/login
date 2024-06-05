package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;
import salaoDataProcess.transactions.Transaction;

public abstract class ClienteTransaction implements Transaction {
    protected final ClienteDB database;

    public ClienteTransaction(ClienteDB database) {
        this.database = database;
    }
}
