import org.junit.Assert;
import org.junit.Test;
import salaoDataOutput.ClienteDB;
import salaoDataOutput.ComandaDB;
import salaoDataOutput.SalaoDBFactory;
import salaoDataOutput.mapDB.SalaoMapDBFactory;
import salaoDataProcess.modeloDeDados.Atendimento;
import salaoDataProcess.modeloDeDados.Atendimentos;
import salaoDataProcess.transactions.atendimentoTransactions.AtendimentoTransaction;
import salaoDataProcess.transactions.atendimentoTransactions.AtendimentoTransactionFactory;
import salaoDataProcess.transactions.clienteTransactions.ClienteTransaction;
import salaoDataProcess.transactions.clienteTransactions.ClienteTransactionFactory;
import salaoDataProcess.transactions.comandaTransactions.ComandaTransaction;
import salaoDataProcess.transactions.comandaTransactions.ComandaTransactionFactory;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandaTest extends AtendimentoTest {
    /*
    * Pagar a comanda é uma transaction de alteração, que é informada depois que a comanda já existe.
    * primeiro cria a comanda
    * depois paga a comanda
    * */
    ComandaDB comandaDB = dbFactory.makeComandaDB();
    ClienteDB clienteDB = dbFactory.makeClienteDB();
    public ComandaTest() {
        super();
        inserirAtendimentos();
        inserirClientes();
    }

    private void inserirClientes() {
        ClienteTransaction c1 =
                ClienteTransactionFactory.makeAdicionarCliente(1, "Joao", clienteDB);
        c1.execute();

        ClienteTransaction c2 =
                ClienteTransactionFactory.makeAdicionarCliente(2, "Maria", clienteDB);
        c2.execute();

        ClienteTransaction c3 =
                ClienteTransactionFactory.makeAdicionarCliente(3, "Pedro", clienteDB);
        c3.execute();
    }

    private void inserirAtendimentos() {
        AtendimentoTransaction a1 =
                AtendimentoTransactionFactory.makeCriarAtendimento(1, profissionalDB.read(1),
                        servicoDB.read(1), atendimentoDB);
        a1.execute();

        AtendimentoTransaction a2 =
                AtendimentoTransactionFactory.makeCriarAtendimento(2, profissionalDB.read(2),
                        servicoDB.read(2), atendimentoDB);
        a2.execute();

        AtendimentoTransaction a3 =
                AtendimentoTransactionFactory.makeCriarAtendimento(3, profissionalDB.read(3),
                        servicoDB.read(3), atendimentoDB);
        a3.execute();
    }

    private Atendimentos montarListaAtedimentos() {
        Atendimentos atendimentos = new Atendimentos();
        atendimentos.add(atendimentoDB.read(1));
        atendimentos.add(atendimentoDB.read(2));
        atendimentos.add(atendimentoDB.read(3));

        return atendimentos;
    }


    @Test
    public void criarComandaTest(){
        Integer comandaId = 1;
        LocalDateTime dt = LocalDateTime.of(2003, Month.MARCH, 3, 13, 3);

        ComandaTransaction criarComanda =
                ComandaTransactionFactory.makeCriarComanda(comandaId, dt, clienteDB.read(1), montarListaAtedimentos(), comandaDB);
        criarComanda.execute();

        Assert.assertEquals(comandaDB.read(1).getCliente().getNome(), "Joao");
        Assert.assertEquals(comandaDB.read(1).getData().getMonth(), Month.MARCH);
        Atendimento a1 = atendimentoDB.read(1);

        Assert.assertEquals(a1.getProfissional().getNome(), "Joao");
        Assert.assertEquals(a1.getServico().getNome(), "Unha");
    }

    @Test
    public void excluirComandaTest(){
        Integer comandaId = 1;
        criarComandaTest();
        ComandaTransaction excluirComanda =
                ComandaTransactionFactory.makeExcluirComanda(comandaId, comandaDB);
        excluirComanda.execute();

        Assert.assertNull(comandaDB.read(comandaId));
    }


}
