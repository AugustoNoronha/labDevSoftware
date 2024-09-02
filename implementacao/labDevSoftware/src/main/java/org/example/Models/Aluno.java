package org.example.Models;

import java.util.List;

public class Aluno extends Pessoa{
    private int creditos;
    private Curso curso;
    private List<Turmas> turmas;

    public Aluno(int id, String nome, String senha, int creditos, Curso curso, List<Turmas> turmas) {
        super(id, nome, senha);
        this.creditos = creditos;
        this.curso = curso;
        this.turmas = turmas;
    }

    public void matricularDisciplinaObrigatoria(int idDiscilpina){

    }

    public void matricularDisciplinaOptativa(int idDiscilpina){

    }

    public void cancelarMtricula(int idDiscilpina){

    }

    public int getCreditos() {
        return this.creditos;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public List<Turmas> getTurmas() {
        return this.turmas;
    }

}
