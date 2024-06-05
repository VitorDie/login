import org.junit.Assert;
import org.junit.Test;
import salaoDataOutput.ProfissionalDB;
import salaoDataOutput.SalaoDBFactory;
import salaoDataOutput.mapDB.ProfissionalMapDB;
import salaoDataOutput.mapDB.SalaoMapDBFactory;
import salaoDataProcess.modeloDeDados.Profissional;
import salaoDataProcess.transactions.profissionalTransactions.ProfissionalTransaction;
import salaoDataProcess.transactions.profissionalTransactions.ProfissionalTransactionFactory;


public class ProfissionalTest {
    SalaoDBFactory dbFactory = new SalaoMapDBFactory();
    ProfissionalDB database = dbFactory.makeProfissionalDB();

    @Test
    public void adicionarProfissionalTest() {
        Integer profissionalId = 1;
        ProfissionalTransaction adicionarProfissional =
                ProfissionalTransactionFactory.makeAdicionarProfissional(profissionalId, "Joao", database);
        adicionarProfissional.execute();

        Profissional proRecebido = database.read(profissionalId);
        Assert.assertEquals("Joao", proRecebido.getNome());
    }

    @Test
    public void alterarProfissionalTest() {
        Integer profissionalId = 1;
        adicionarProfissionalTest();

        ProfissionalTransaction alterarProfissional =
                ProfissionalTransactionFactory.makeAlterarProfissionalNome(profissionalId,
                        "Pedro", database);
        alterarProfissional.execute();

        Profissional proRecebido = database.read(profissionalId);
        Assert.assertEquals("Pedro", proRecebido.getNome());
    }

    @Test
    public void excluirProfissionalTest() {
        Integer profissionalId = 1;
        adicionarProfissionalTest();
        ProfissionalTransaction exlcuirProfissional =
                ProfissionalTransactionFactory.makeExcluirProfissional(profissionalId, database);

        exlcuirProfissional.execute();

        Profissional proRecebido = database.read(profissionalId);
        Assert.assertNull(proRecebido);
    }
}