package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Cliente;

public interface ClienteDB {
    public void create(Integer id, Cliente cliente);
    public Cliente read(Integer id);
    public void update(Integer id, Cliente cliente);
    public void delete(Integer id);
}
