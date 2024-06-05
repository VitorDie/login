package salaoDataProcess.modeloDeDados;

import java.time.LocalDateTime;

public class Comanda {
    private LocalDateTime data;
    private Cliente cliente;
    private String pagamento;
    private Atendimentos atendimentos;

    public Comanda(LocalDateTime data, Cliente cliente, String pagamento, Atendimentos atendimentos) {
        this.data = data;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.atendimentos = atendimentos;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPagamento() {
        return pagamento;
    }

    public Atendimentos getAtendimentos() {
        return atendimentos;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public void setAtendimentos(Atendimentos atendimentos) {
        this.atendimentos = atendimentos;
    }
}
