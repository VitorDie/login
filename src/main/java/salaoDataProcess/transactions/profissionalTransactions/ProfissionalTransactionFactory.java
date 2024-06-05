package salaoDataProcess.transactions.profissionalTransactions;

import salaoDataOutput.ProfissionalDB;

public class ProfissionalTransactionFactory {
    public static AdicionarProfissional makeAdicionarProfissional(Integer id, String nome, ProfissionalDB database) {
        return new AdicionarProfissional(id, nome, database);
    }

    public static ExcluirProfissional makeExcluirProfissional(Integer id, ProfissionalDB database) {
        return new ExcluirProfissional(id, database);
    }

    public static AlterarProfissionalNome makeAlterarProfissionalNome(Integer id, String nome, ProfissionalDB database) {
        return new AlterarProfissionalNome(id, nome, database);
    }
}