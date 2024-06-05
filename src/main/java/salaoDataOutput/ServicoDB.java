package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Servico;

public interface ServicoDB {
    public void create(Integer id, Servico servico);
    public Servico read(Integer id);
    public void update(Integer id, Servico servico);
    public void delete(Integer id);
}
