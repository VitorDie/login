package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;

public class ExcluirCliente extends ClienteTransaction{
    private final Integer id;

    public ExcluirCliente(Integer id, ClienteDB database) {
        super(database);
        this.id = id;
    }

    @Override
    public void execute() {
        database.delete(id);
    }
}
