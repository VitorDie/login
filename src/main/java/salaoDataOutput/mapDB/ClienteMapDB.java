package salaoDataOutput.mapDB;

import salaoDataOutput.ClienteDB;
import salaoDataProcess.modeloDeDados.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteMapDB implements ClienteDB {
    Map<Integer, Cliente> db = new HashMap<Integer, Cliente>();
    @Override
    public void create(Integer id, Cliente cliente) {
        db.put(id, cliente);
    }

    @Override
    public Cliente read(Integer id) {
        return db.get(id);
    }

    @Override
    public void update(Integer id, Cliente cliente) {
        db.replace(id, cliente);
    }

    @Override
    public void delete(Integer id) {
        db.remove(id);
    }
}
