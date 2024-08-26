package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Turmas {
    public Professor Professor;
    public Disciplina Diciplina;
    public List<Aluno> Alunos;

    public Turmas(org.example.Models.Professor professor, Disciplina diciplina, List<Aluno> alunos) {
        Professor = professor;
        Diciplina = diciplina;
        Alunos = alunos;
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
        return  professor;
    }

    public org.example.Models.Professor getProfessor() {
        return Professor;
    }

    public void setProfessor(org.example.Models.Professor professor) {
        Professor = professor;
    }

    public Disciplina getDiciplina() {
        return Diciplina;
    }

    public void setDiciplina(Disciplina diciplina) {
        Diciplina = diciplina;
    }

    public List<Aluno> getAlunos() {
        return Alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        Alunos = alunos;
    }
}
