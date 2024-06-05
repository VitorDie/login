package salaoDataProcess.transactions.atendimentoTransactions;

import salaoDataOutput.AtendimentoDB;
import salaoDataProcess.modeloDeDados.Profissional;
import salaoDataProcess.modeloDeDados.Servico;

public class AtendimentoTransactionFactory {
    public static AtendimentoTransaction makeCriarAtendimento(Integer id, Profissional profissional, Servico servico, AtendimentoDB database) {
        return new CriarAtendimento(id, profissional, servico, database);
    }

    public static AtendimentoTransaction makeExcluirAtendimento(Integer id, AtendimentoDB database) {
        return new ExcluirAtendimento(id, database);
    }

    public static AlterarAtendimento makeAlterarAtendimentoProfissional(Integer id, Profissional profissional, AtendimentoDB database) {
        return new AlterarAtendimentoProfissional(id, profissional, database);
    }

    public static AlterarAtendimento makeAlterarAtendimentoServico(Integer id, Servico servico, AtendimentoDB database) {
        return new AlterarAtendimentoServico(id, servico, database);
    }
}
