package salaoDataProcess.modeloDeDados;

public class Atendimento {
    private Profissional profissional;
    private Servico servico;

    public Atendimento(Profissional profissional, Servico servico) {
        this.profissional = profissional;
        this.servico = servico;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
