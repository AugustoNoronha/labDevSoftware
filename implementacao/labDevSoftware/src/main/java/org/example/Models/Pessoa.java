package org.example.Models;

public class Pessoa {

    private String nome;
    private String senha;

    public Pessoa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean login(String senha, String nome) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}
