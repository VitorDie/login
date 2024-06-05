package salaoDataOutput.mapDB;

import salaoDataOutput.AtendimentoDB;
import salaoDataProcess.modeloDeDados.Atendimento;

import java.util.HashMap;
import java.util.Map;

public class AtendimentoMapDB implements AtendimentoDB {
    private Map<Integer, Atendimento> database = new HashMap<>();

    @Override
    public void create(Integer id, Atendimento atendimento) {
        database.put(id, atendimento);
    }

    @Override
    public Atendimento read(Integer id) {
        return database.get(id);
    }

    @Override
    public void update(Integer id, Atendimento atendimento) {
        database.replace(id, atendimento);
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }
}
