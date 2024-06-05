package salaoDataProcess.transactions.comandaTransactions;

import salaoDataOutput.ComandaDB;
import salaoDataProcess.modeloDeDados.Atendimentos;
import salaoDataProcess.modeloDeDados.Cliente;

import java.time.LocalDateTime;

public class ComandaTransactionFactory {
    public static ComandaTransaction makeCriarComanda(Integer id, LocalDateTime data, Cliente cliente, Atendimentos atendimentos, ComandaDB database) {
        return new CriarComanda(id, data, cliente, atendimentos, database);
    }

    public static ComandaTransaction makeExcluirComanda(Integer id, ComandaDB database){
        return new ExcluirComanda(id, database);
    }
}
