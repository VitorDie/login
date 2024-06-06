package br.edu.fesa.teladelogin.comandaData;

import java.time.LocalDateTime;

public class ComandaModel {
    private Integer id;
    private LocalDateTime data_comanda;
    private String cliente;
    private String profissional;
    private String servico;
    private String pagamento;
    private Double valor;

    public ComandaModel(Integer id, LocalDateTime data_comanda, String cliente, String profissional, String servico, String pagamento, Double valor) {
        this.id = id;
        this.data_comanda = data_comanda;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData_comanda() {
        return data_comanda;
    }

    public void setData_comanda(LocalDateTime data_comanda) {
        this.data_comanda = data_comanda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}