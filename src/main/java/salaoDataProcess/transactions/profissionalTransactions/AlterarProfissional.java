package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;

public abstract class AlterarProfissional extends ProfissionalTransaction {
    protected AlterarProfissional(ProfissionalDB database) {
        super(database);
    }
}
