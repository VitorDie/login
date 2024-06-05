package salaoDataProcess.transactions.servicoTransactions;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Servico;

public class ServicoTransactionFactory {
    public static CriarProgressiva makeCriarProgressiva(Integer id, Double valor, ServicoDB database){
        return new CriarProgressiva(id, valor, database);
    }

    public static ServicoTransaction makeCriarServico(Integer servicoId, String nome, Double valor, ServicoDB database) {
        return new CriarServico(servicoId, nome, valor, database);
    }

    public static ExcluirServico makeExcluirServico(Integer id, ServicoDB database){
        return new ExcluirServico(id, database);
    }

    public static AlterarServico makeAlterarServicoNome(Integer servicoId, String novoNome, ServicoDB database) {
        return new AlterarServicoNome(servicoId, novoNome, database);
    }

    public static AlterarServico makeAlterarServicoValor(Integer servicoId, Double novoValor, ServicoDB database) {
        return new AlterarServicoValor(servicoId, novoValor, database);
    }
}
