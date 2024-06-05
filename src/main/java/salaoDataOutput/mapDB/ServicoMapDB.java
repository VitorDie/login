package salaoDataOutput.mapDB;

import salaoDataOutput.ServicoDB;
import salaoDataProcess.modeloDeDados.Servico;

import java.util.HashMap;
import java.util.Map;

public class ServicoMapDB implements ServicoDB {

    Map<Integer, Servico> database = new HashMap<Integer, Servico>();

    @Override
    public void create(Integer id, Servico servico) {
        database.put(id, servico);
    }

    @Override
    public Servico read(Integer id) {
        return database.get(id);
    }

    @Override
    public void update(Integer id, Servico servico) {
        database.replace(id, servico);
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }
}
