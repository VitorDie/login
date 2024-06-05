package salaoDataProcess.transactions.comandaTransactions;

import salaoDataOutput.ComandaDB;

public class ExcluirComanda extends ComandaTransaction{

    private final Integer id;

    protected ExcluirComanda(Integer id, ComandaDB database){
        super(database);
        this.id = id;
    }

    @Override
    public void execute() {
        database.delete(id);
    }
}
