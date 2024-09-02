package org.example.Models;

import org.example.Models.Enums.Status;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private int CREDITOS;
    private int CARGA_HORARIA;
    private List<Disciplina> disciplina;
    private int NUMERO_MAXIMO_ALUNOS;
    private org.example.Models.Enums.Status Status;

    public Disciplina(int id, String nome, int CREDITOS, int CARGA_HORARIA, List<Disciplina> disciplina, int NUMERO_MAXIMO_ALUNOS, org.example.Models.Enums.Status status) {
        this.id = id;
        this.nome = nome;
        this.CREDITOS = CREDITOS;
        this.CARGA_HORARIA = CARGA_HORARIA;
        this.disciplina = disciplina;
        this.NUMERO_MAXIMO_ALUNOS = NUMERO_MAXIMO_ALUNOS;
        Status = status;
    }

    public Boolean validarNumeroMinimoDeAlunos(){
        return true;
    }

    public void cancelarDisciplina(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCARGA_HORARIA() {
        return CARGA_HORARIA;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public int getNUMERO_MAXIMO_ALUNOS() {
        return NUMERO_MAXIMO_ALUNOS;
    }

    public Status getStatus() {
        return Status;
    }

}
