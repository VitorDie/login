package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Progressiva;
import salaoDataProcess.modeloDeDados.Servico;

public class CriarProgressiva extends CriarServico {

    public CriarProgressiva(Integer id, Double valor, ServicoDB database) {
        super(id, Progressiva.nomePadrao(), valor, database);
    }

    @Override
    public void execute() {
        Servico servico = new Progressiva(super.valor);
        database.create(super.id, servico);
    }
}
