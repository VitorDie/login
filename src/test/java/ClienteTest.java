import org.junit.Assert;
import org.junit.Test;
import salaoDataOutput.ClienteDB;
import salaoDataOutput.SalaoDBFactory;
import salaoDataOutput.mapDB.ClienteMapDB;
import salaoDataOutput.mapDB.SalaoMapDBFactory;
import salaoDataProcess.modeloDeDados.Cliente;
import salaoDataProcess.transactions.clienteTransactions.ClienteTransaction;
import salaoDataProcess.transactions.clienteTransactions.ClienteTransactionFactory;

public class ClienteTest {
    SalaoDBFactory dbFactory = new SalaoMapDBFactory();
    ClienteDB database = dbFactory.makeClienteDB();

    @Test
    public void adicionarClienteTest() {
        Integer clienteId = 1;
        ClienteTransaction adicionarCliente =
                ClienteTransactionFactory.makeAdicionarCliente(clienteId, "Lucia", database);
        adicionarCliente.execute();

        Cliente c = database.read(clienteId);

        Assert.assertEquals(c.getNome(), "Lucia");
    }

    @Test
    public void alterarClienteNomeTest() {
        adicionarClienteTest();

        Integer clienteId = 1;

        ClienteTransaction alterarClienteNome =
                ClienteTransactionFactory.makeAlterarClienteNome(clienteId, "Maria", database);
        alterarClienteNome.execute();

        Assert.assertEquals("Maria", database.read(clienteId).getNome());
    }

    @Test
    public void excluirClienteTest() {
        adicionarClienteTest();

        Integer clienteId = 1;
        ClienteTransaction excluirCliente = ClienteTransactionFactory.makeExcluirCliente(clienteId, database);
        excluirCliente.execute();

        Assert.assertNull(database.read(clienteId));
    }
}
