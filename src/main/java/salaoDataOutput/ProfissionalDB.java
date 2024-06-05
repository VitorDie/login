package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Profissional;

public interface ProfissionalDB {
    public void create(Integer id, Profissional profissional);
    public Profissional read(Integer id);
    public void update(Integer id, Profissional profissional);
    public void delete(Integer id);
}
