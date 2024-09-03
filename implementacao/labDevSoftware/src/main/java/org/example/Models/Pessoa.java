package org.example.Models;

public class Pessoa {
    private int id;
    private String nome;
    private String senha;

    public Pessoa(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean login(String senha, int id) {
        return this.id == id && this.senha.equals(senha);
    }
}
