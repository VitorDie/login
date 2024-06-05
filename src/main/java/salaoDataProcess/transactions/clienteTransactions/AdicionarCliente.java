package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;
import salaoDataProcess.modeloDeDados.Cliente;

public class AdicionarCliente extends ClienteTransaction {
    private final String nome;
    private final Integer id;

    public AdicionarCliente(Integer id, String nome, ClienteDB database) {
        super(database);
        this.nome = nome;
        this.id = id;
    }

    @Override
    public void execute() {
        database.create(id, new Cliente(nome));
    }
}
