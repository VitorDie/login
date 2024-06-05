package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;

public abstract class AlterarCliente extends ClienteTransaction {
    public AlterarCliente(ClienteDB database) {
        super(database);
    }
}
