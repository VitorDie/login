package salaoDataProcess.transactions.clienteTransactions;

import salaoDataOutput.ClienteDB;

public class ClienteTransactionFactory {
    public static AdicionarCliente makeAdicionarCliente(Integer id, String nome, ClienteDB database) {
        return new AdicionarCliente(id, nome, database);
    }

    public static AlterarClienteNome makeAlterarClienteNome(Integer id, String nome, ClienteDB database) {
        return new AlterarClienteNome(id, nome, database);
    }

    public static ExcluirCliente makeExcluirCliente(Integer id, ClienteDB database) {
        return new ExcluirCliente(id, database);
    }
}
