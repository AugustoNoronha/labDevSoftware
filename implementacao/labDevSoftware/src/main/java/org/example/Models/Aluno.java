package org.example.Models;

import java.util.List;

public class Aluno extends Pessoa{
    private int creditos;
    private Curso Curso;
    private List<Turmas> Turmas;

    public Aluno(int id, String nome, String senha, int creditos, org.example.Models.Curso curso, List<org.example.Models.Turmas> turmas) {
        super(id, nome, senha);
        this.creditos = creditos;
        Curso = curso;
        Turmas = turmas;
    }

    public void matricularDisciplinaObrigatoria(int idDiscilpina){

    }

    public void matricularDisciplinaOptativa(int idDiscilpina){

    }

    public void cancelarMtricula(int idDiscilpina){

    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public org.example.Models.Curso getCurso() {
        return Curso;
    }

    public void setCurso(org.example.Models.Curso curso) {
        Curso = curso;
    }

    public List<org.example.Models.Turmas> getTurmas() {
        return Turmas;
    }

    public void setTurmas(List<org.example.Models.Turmas> turmas) {
        Turmas = turmas;
    }
}
