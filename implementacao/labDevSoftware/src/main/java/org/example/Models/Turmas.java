package org.example.Models;

import org.example.Models.Enums.Status;
import org.example.Utils.Arquivos;

import java.util.ArrayList;
import java.util.List;

public class Turmas {
    public int id;
    public Professor professor;
    public Disciplina disciplina;
    public List<Aluno> alunos;
    public String semestre;
    public String ano;

    public Turmas(int id, Professor professor, Disciplina disciplina, List<Aluno> alunos, String semestre, String ano) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.semestre = semestre;
        this.ano = ano;
    }

    public List<Aluno> adicionarAluno(Aluno aluno, List<Aluno> alunos){
        alunos.add(aluno);
        Arquivos.armazenarValores(aluno,"C:\\temp\\alunos.txt");
        return alunos;
    }

    public List<Aluno> removerAluno(Aluno Aluno, List<Aluno> alunos){
        alunos.remove(alunos);
        return alunos;
    }

    public Professor selecionarProfessor(Professor professor){
        return  this.professor;
    }

    public int getId() {
        return id;
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

    public String getSemestre() {
        return semestre;
    }

    public String getAno() {
        return ano;
    }
}
