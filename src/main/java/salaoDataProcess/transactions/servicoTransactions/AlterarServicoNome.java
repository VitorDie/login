package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Servico;

public class AlterarServicoNome extends AlterarServico {
    private final Integer servicoId;
    private final String novoNome;

    protected AlterarServicoNome(Integer servicoId, String novoNome, ServicoDB database) {
        super(database);
        this.servicoId = servicoId;
        this.novoNome = novoNome;
    }

    @Override
    public void execute() {
        Servico servico = database.read(servicoId);
        servico.setNome(novoNome);
        database.update(servicoId, servico);
    }
}
