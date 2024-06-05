package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Comanda;

public interface ComandaDB {
    public void create(Integer id, Comanda comanda);
    public Comanda read(Integer id);
    public void update(Integer id, Comanda comanda);
    public void delete(Integer id);

}
