package salaoDataOutput.mapDB;

import salaoDataOutput.*;

public class SalaoMapDBFactory implements SalaoDBFactory {
    @Override
    public AtendimentoDB makeAtendimentoDB() {
        return new AtendimentoMapDB();
    }

    @Override
    public ClienteDB makeClienteDB() {
        return new ClienteMapDB();
    }

    @Override
    public ComandaDB makeComandaDB() {
        return new ComandaMapDB();
    }

    @Override
    public PagamentoDB makePagamentoDB() {
        return null;
    }

    @Override
    public ProfissionalDB makeProfissionalDB() {
        return new ProfissionalMapDB();
    }

    @Override
    public ServicoDB makeServicoDB() {
        return new ServicoMapDB();
    }
}
