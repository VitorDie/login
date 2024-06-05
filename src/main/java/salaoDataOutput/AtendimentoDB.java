package salaoDataOutput;

import salaoDataProcess.modeloDeDados.Atendimento;

public interface AtendimentoDB {
    public void create(Integer id, Atendimento atendimento);
    public Atendimento read(Integer id);
    public void update(Integer id, Atendimento atendimento);
    public void delete(Integer id);
}
