package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Atendimento;

public interface SalaoDBFactory {
    AtendimentoDB makeAtendimentoDB();
    ClienteDB makeClienteDB();
    ComandaDB makeComandaDB();
    PagamentoDB makePagamentoDB();
    ProfissionalDB makeProfissionalDB();
    ServicoDB makeServicoDB();
}
