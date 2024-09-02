package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Turmas {
    public Professor professor;
    public Disciplina disciplina;
    public List<Aluno> alunos;

    public Turmas(Professor professor, Disciplina disciplina, List<Aluno> alunos) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
    }

    public List<Aluno> adicionarAluno(Aluno aluno){
        List<Aluno> alunosList = new ArrayList<>();
        return  alunosList;
    }

    public List<Aluno> removerAluno(Aluno Aluno){
        List<Aluno> alunosList = new ArrayList<>();
        return  alunosList;
    }

    public Professor selecionarProfessor(Professor professor){
        return  this.professor;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }


    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
