package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;
import salaoDataProcess.modeloDeDados.Cliente;

public class AlterarClienteNome extends AlterarCliente{
    private final String nome;
    private final Integer id;

    public AlterarClienteNome(Integer id, String nome, ClienteDB database) {
        super(database);
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void execute() {
        Cliente cliente = database.read(id);
        cliente.setNome(nome);
        database.update(id, cliente);
    }
}
