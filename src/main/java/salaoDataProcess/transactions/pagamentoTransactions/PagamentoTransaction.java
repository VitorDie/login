package salaoDataProcess.transactions.pagamentoTransactions;

import salaoDataOutput.PagamentoDB;
import salaoDataProcess.transactions.Transaction;

public abstract class PagamentoTransaction implements Transaction {
    protected final PagamentoDB database;

    protected PagamentoTransaction(PagamentoDB database) {
        this.database = database;
    }
}
