package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;
import salaoDataProcess.modeloDeDados.Atendimento;
import salaoDataProcess.modeloDeDados.Servico;

public class AlterarAtendimentoServico extends AlterarAtendimento{
    private final Integer id;
    private final Servico servico;

    public AlterarAtendimentoServico(Integer id, Servico servico, AtendimentoDB database) {
        super(database);
        this.id = id;
        this.servico = servico;
    }

    @Override
    public void execute() {
        Atendimento atendimento = database.read(id);
        atendimento.setServico(servico);
        database.update(id, atendimento);
    }
}
