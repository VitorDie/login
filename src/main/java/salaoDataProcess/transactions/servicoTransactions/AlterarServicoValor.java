package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Servico;

public class AlterarServicoValor extends AlterarServico{
    private final Integer id;
    private final Double novoValor;

    protected AlterarServicoValor(Integer id, Double novoValor, ServicoDB database) {
        super(database);
        this.id = id;
        this.novoValor = novoValor;
    }

    @Override
    public void execute() {
        Servico servico = database.read(id);
        servico.setValor(novoValor);
        database.update(id, servico);
    }
}
