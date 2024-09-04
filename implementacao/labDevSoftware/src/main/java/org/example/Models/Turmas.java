package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Turmas {
    private int id;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private String semestre;
    private String ano;

    public Turmas(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public Turmas(Professor professor, Disciplina disciplina, List<Aluno> alunos, String semestre, String ano) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.semestre = semestre;
        this.ano = ano;
    }

    public List<Aluno> adicionarAluno(Aluno aluno) {
        if (this.alunos.size() < this.disciplina.getNUMERO_MAXIMO_ALUNOS()) {
            this.alunos.add(aluno);
        } else {
            System.out.println("Não é possível adicionar aluno. Limite máximo de alunos atingido.");
        }
        return this.alunos;
    }

    public List<Aluno> removerAluno(Aluno aluno) {
        if (this.alunos.contains(aluno)) {
            this.alunos.remove(aluno);
        } else {
            System.out.println("Aluno não encontrado na turma.");
        }
        return this.alunos;
    }

    public boolean isOptativa() {
        return this.disciplina.isOptativa();
    }

    public Professor selecionarProfessor(Professor professor) {
        return this.professor;
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