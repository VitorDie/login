package br.edu.fesa.teladelogin.funcionarioData;

public class FuncionarioModel {
    int id;
    String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FuncionarioModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
