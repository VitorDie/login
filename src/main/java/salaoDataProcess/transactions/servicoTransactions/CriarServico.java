package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Servico;

public class CriarServico extends ServicoTransaction{
    protected final Integer id;
    protected final String nome;
    protected final Double valor;

    public CriarServico(Integer id, String nome, Double valor, ServicoDB database) {
        super(database);
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public void execute() {
        Servico servico = new Servico(nome, valor);
        database.create(id, servico);
    }
}
