package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;

public abstract class AlterarAtendimento extends AtendimentoTransaction {
    public AlterarAtendimento(AtendimentoDB database) {
        super(database);
    }
}
