package salaoDataOutput.mapDB;

import salaoDataOutput.ComandaDB;
import salaoDataProcess.modeloDeDados.Comanda;

import java.util.HashMap;
import java.util.Map;

public class ComandaMapDB implements ComandaDB {
    Map<Integer, Comanda> database = new HashMap<>();
    @Override
    public void create(Integer id, Comanda comanda) {
       database.put(id, comanda);
    }

    @Override
    public Comanda read(Integer id) {
        return database.get(id);
    }

    @Override
    public void update(Integer id, Comanda comanda) {
        database.replace(id, comanda);
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }
}
