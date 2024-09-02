package org.example.Models;

import org.example.Models.Enums.Status;

import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int CREDITOS;
    private int CARGA_HORARIA;
    private List<Disciplina> disciplina;

    public Curso(int id, String nome, int CREDITOS, int CARGA_HORARIA, List<Disciplina> disciplina) {
        this.id = id;
        this.nome = nome;
        this.CREDITOS = CREDITOS;
        this.CARGA_HORARIA = CARGA_HORARIA;
        this.disciplina = disciplina;
    }

    public void adicionarDisciplina(Disciplina disciplina){

    }

    public void removerDisciplina(int idDisciplina){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCREDITOS() {
        return CREDITOS;
    }

    public int getCARGA_HORARIA() {
        return CARGA_HORARIA;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

}
