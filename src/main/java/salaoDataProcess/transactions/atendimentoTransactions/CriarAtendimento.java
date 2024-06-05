package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;
import salaoDataProcess.modeloDeDados.Atendimento;
import salaoDataProcess.modeloDeDados.Profissional;
import salaoDataProcess.modeloDeDados.Servico;

public class CriarAtendimento extends AtendimentoTransaction{
    private final Integer id;
    private final Profissional profissional;
    private final Servico servico;

    public CriarAtendimento(Integer id, Profissional profissional, Servico servico, AtendimentoDB database) {
        super(database);
        this.id = id;
        this.profissional = profissional;
        this.servico = servico;
    }

    @Override
    public void execute() {
        Atendimento atendimento = new Atendimento(profissional, servico);

        database.create(id, atendimento);
    }
}
