import org.junit.Assert;
import org.junit.Test;
import salaoDataOutput.ServicoDB;
import salaoDataOutput.mapDB.SalaoMapDBFactory;
import salaoDataOutput.mapDB.ServicoMapDB;
import salaoDataProcess.modeloDeDados.Servico;
import salaoDataProcess.transactions.servicoTransactions.*;
import salaoDataOutput.SalaoDBFactory;

public class ServicoTest {
    SalaoDBFactory dbFactory = new SalaoMapDBFactory();
    ServicoDB database = dbFactory.makeServicoDB();

    @Test
    public void criarProgressivaTest(){
        Integer servicoId = 1;

        ServicoTransaction criarServico = ServicoTransactionFactory.makeCriarProgressiva(servicoId, 100.00, database);
        criarServico.execute();

        Servico servicoRecebido = database.read(servicoId);
        Double valorDoServico = servicoRecebido.getValor();
        Assert.assertEquals(100.00, (double)valorDoServico, .001);
    }

    @Test
    public void criarServicoTest() {
        Integer servicoId = 2;

        ServicoTransaction criarServico = ServicoTransactionFactory.makeCriarServico(servicoId, "raspar a cabeca", 2.0, database);
        criarServico.execute();

        Servico servicoRecebido = database.read(servicoId);

        Assert.assertEquals(servicoRecebido.getValor(), 2.0, .001);
        Assert.assertEquals(servicoRecebido.getNome(), "raspar a cabeca");
    }
    @Test
    public void excluirServicoTest(){
        criarServicoTest();
        Integer servicoId = 2;

        ServicoTransaction excluirServico = ServicoTransactionFactory.makeExcluirServico(servicoId, database);
        excluirServico.execute();

        Servico servicoRecebido = database.read(servicoId);

        Assert.assertNull(servicoRecebido);
    }

    @Test
    public void alterarServicoNomeTest(){
        criarServicoTest();

        Integer servicoId = 2;
        Servico servicoRecebido = database.read(servicoId);

        Assert.assertEquals(servicoRecebido.getNome(), "raspar a cabeca");

        String novoNome = "pintar o cabelo";
        AlterarServico alterarServicoNome = ServicoTransactionFactory.makeAlterarServicoNome(servicoId, novoNome, database);
        alterarServicoNome.execute();

        servicoRecebido = database.read(servicoId);

        Assert.assertEquals(servicoRecebido.getNome(), novoNome);
    }

    @Test
    public void alterarServicoValorTest() {
        criarServicoTest();
        Integer servicoId = 2;
        Double novoValor = 100.0;

        Servico servicoRecebido = database.read(servicoId);

        Assert.assertEquals(servicoRecebido.getValor(), 2.0, .001);

        AlterarServico alterarServicoValor = ServicoTransactionFactory.makeAlterarServicoValor(servicoId, novoValor, database);
        alterarServicoValor.execute();

        servicoRecebido = database.read(servicoId);

        Assert.assertEquals(servicoRecebido.getValor(), novoValor);
    }
}
