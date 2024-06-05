package salaoDataOutput.mapDB;

import salaoDataOutput.ProfissionalDB;
import salaoDataProcess.modeloDeDados.Profissional;

import java.util.HashMap;
import java.util.Map;

public class ProfissionalMapDB implements ProfissionalDB {
    Map<Integer, Profissional> db = new HashMap<Integer, Profissional>();

    @Override
    public void create(Integer id, Profissional profissional) {
        db.put(id, profissional);
    }

    @Override
    public Profissional read(Integer id) {
        return db.get(id);
    }

    @Override
    public void update(Integer id, Profissional profissional) {
        db.replace(id, profissional);
    }

    @Override
    public void delete(Integer id) {
        db.remove(id);
    }
}
