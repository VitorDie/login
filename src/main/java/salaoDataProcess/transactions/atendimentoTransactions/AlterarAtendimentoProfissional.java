package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;
import salaoDataOutput.ProfissionalDB;
import salaoDataProcess.modeloDeDados.Atendimento;
import salaoDataProcess.modeloDeDados.Profissional;

public class AlterarAtendimentoProfissional extends AlterarAtendimento{
    private final Integer id;
    private final Profissional profissional;

    public AlterarAtendimentoProfissional(Integer id, Profissional profissional, AtendimentoDB database) {
        super(database);
        this.id = id;
        this.profissional = profissional;
    }

    @Override
    public void execute() {
        Atendimento atendimento = database.read(id);
        atendimento.setProfissional(profissional);
        database.update(id, atendimento);
    }
}
