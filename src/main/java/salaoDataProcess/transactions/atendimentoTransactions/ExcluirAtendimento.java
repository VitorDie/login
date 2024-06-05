package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;

public class ExcluirAtendimento extends AtendimentoTransaction{
    private final Integer id;

    public ExcluirAtendimento(Integer id, AtendimentoDB database) {
        super(database);
        this.id = id;
    }

    @Override
    public void execute() {
        database.delete(id);
    }
}
