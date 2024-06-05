package salaoDataProcess.transactions.comandaTransactions;

import salaoDataOutput.ComandaDB;
import salaoDataProcess.modeloDeDados.Atendimentos;
import salaoDataProcess.modeloDeDados.Cliente;
import salaoDataProcess.modeloDeDados.Comanda;

import java.time.LocalDateTime;

public class CriarComanda extends ComandaTransaction{


    private final Integer id;
    private final LocalDateTime data;
    private final Cliente cliente;
    private final Atendimentos atendimentos;

    protected CriarComanda(Integer id, LocalDateTime data, Cliente cliente, Atendimentos atendimentos, ComandaDB database) {
        super(database);
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.atendimentos = atendimentos;
    }
    @Override
    public void execute() {
       database.create(id, new Comanda(data, cliente, "", atendimentos));
    }
}
