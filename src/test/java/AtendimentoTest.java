import org.junit.Assert;
import org.junit.Test;
import salaoDataOutput.AtendimentoDB;
import salaoDataOutput.ProfissionalDB;
import salaoDataOutput.SalaoDBFactory;
import salaoDataOutput.ServicoDB;
import salaoDataOutput.mapDB.SalaoMapDBFactory;
import salaoDataProcess.modeloDeDados.Atendimento;
import salaoDataProcess.modeloDeDados.Atendimentos;
import salaoDataProcess.modeloDeDados.Profissional;
import salaoDataProcess.modeloDeDados.Servico;
import salaoDataProcess.transactions.atendimentoTransactions.AlterarAtendimento;
import salaoDataProcess.transactions.atendimentoTransactions.AlterarAtendimentoProfissional;
import salaoDataProcess.transactions.atendimentoTransactions.AtendimentoTransaction;
import salaoDataProcess.transactions.atendimentoTransactions.AtendimentoTransactionFactory;
import salaoDataProcess.transactions.profissionalTransactions.AdicionarProfissional;
import salaoDataProcess.transactions.profissionalTransactions.ProfissionalTransaction;
import salaoDataProcess.transactions.profissionalTransactions.ProfissionalTransactionFactory;
import salaoDataProcess.transactions.servicoTransactions.ServicoTransaction;
import salaoDataProcess.transactions.servicoTransactions.ServicoTransactionFactory;

import javax.annotation.processing.Generated;

public class AtendimentoTest {
    protected SalaoDBFactory dbFactory = new SalaoMapDBFactory();
    protected AtendimentoDB atendimentoDB;
    protected ProfissionalDB profissionalDB;
    protected ServicoDB servicoDB;

    public void setupAtendimentoMapDB() {
        ProfissionalTransaction p1 =
                ProfissionalTransactionFactory.makeAdicionarProfissional(1, "Joao", profissionalDB);
        p1.execute();
        ProfissionalTransaction p2 =
                ProfissionalTransactionFactory.makeAdicionarProfissional(2, "Pedro", profissionalDB);
        p2.execute();
        ProfissionalTransaction p3 =
                ProfissionalTransactionFactory.makeAdicionarProfissional(3, "Tiago", profissionalDB);
        p3.execute();

        ServicoTransaction s1 =
                ServicoTransactionFactory.makeCriarServico(1, "Unha", 20.0, servicoDB);
        s1.execute();
        ServicoTransaction s2 =
                ServicoTransactionFactory.makeCriarProgressiva(2, 30.0, servicoDB);
        s2.execute();
        ServicoTransaction s3 = ServicoTransactionFactory.makeCriarServico(3, "Cilios", 50.0, servicoDB);
        s3.execute();
    }

    public AtendimentoTest() {

        atendimentoDB = dbFactory.makeAtendimentoDB();
        profissionalDB = dbFactory.makeProfissionalDB();
        servicoDB = dbFactory.makeServicoDB();

        setupAtendimentoMapDB();
    }

    @Test
    public void criarAtendimentoTest() {
        Profissional p1 = profissionalDB.read(1);
        Servico s1 = servicoDB.read(1);

        Integer atendimentoId = 1;
        AtendimentoTransaction criarAtendimento1 =
                AtendimentoTransactionFactory.makeCriarAtendimento(atendimentoId, p1, s1, atendimentoDB);
        criarAtendimento1.execute();

        Atendimento atendimentoRecebido = atendimentoDB.read(atendimentoId);
        Profissional profissionalDoAtendimento = atendimentoRecebido.getProfissional();
        Servico servicoDoAtendimento = atendimentoRecebido.getServico();

        Assert.assertEquals(profissionalDoAtendimento.getNome(), "Joao");

        Assert.assertEquals(servicoDoAtendimento.getNome(), "Unha");
        Assert.assertEquals(servicoDoAtendimento.getValor(), 20.0, .001);
    }

    @Test
    public void excluirAtendimentoTest() {
        criarAtendimentoTest();

        Integer atendimentoId = 1;
        AtendimentoTransaction excluirAtendimento = AtendimentoTransactionFactory.makeExcluirAtendimento(atendimentoId, atendimentoDB);
        excluirAtendimento.execute();

        Atendimento atendimentoRecebido = atendimentoDB.read(atendimentoId);

        Assert.assertNull(atendimentoRecebido);
    }

    @Test
    public void alterarAtendimentoProfissionalTest() {
        criarAtendimentoTest();
        Profissional p2 = profissionalDB.read(2);

        Integer atendimentoId = 1;
        AlterarAtendimento alterarAtendimentoProfissional =
                AtendimentoTransactionFactory.makeAlterarAtendimentoProfissional(atendimentoId, p2, atendimentoDB);
        alterarAtendimentoProfissional.execute();

        Atendimento atendimentoRecebido = atendimentoDB.read(atendimentoId);
        Profissional profissionalDoAtendimento = atendimentoRecebido.getProfissional();

        Assert.assertEquals(profissionalDoAtendimento.getNome(), "Pedro");
    }

    @Test
    public void alterarAtendimentoServicoTest() {
        criarAtendimentoTest();
        Servico s2 = servicoDB.read(2);

        Integer atendimentoId = 1;
        AlterarAtendimento alterarAtendimentoServico =
                AtendimentoTransactionFactory.makeAlterarAtendimentoServico(atendimentoId, s2, atendimentoDB);
        alterarAtendimentoServico.execute();

        Atendimento atendimentoRecebido = atendimentoDB.read(atendimentoId);
        Servico servicoDoAtendimento = atendimentoRecebido.getServico();

        Assert.assertEquals(servicoDoAtendimento.getNome(), "Progressiva");
        Assert.assertEquals(servicoDoAtendimento.getValor(), 30.0, .001);
    }
}
