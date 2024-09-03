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

    public void matricularDisciplinaObrigatoria(Turma turma) {
        if (this.curso.getDisciplinaById(turma.getDisciplina().getId()) == null) {
            System.out.println("Disciplina não encontrada no curso.");
            return;
        }

        if (obrigatoriasMaximasAtingidas()) {
            System.out.println("Você já atingiu o limite de disciplinas obrigatórias.");
            return;
        }

        if (turma.getAlunosMatriculados().size() >= turma.getDisciplina().getNUMERO_MAXIMO_ALUNOS()) {
            System.out.println("A turma já atingiu o limite máximo de alunos.");
            return;
        }

        this.turmas.add(turma);
        turma.addAluno(this);
        System.out.println("Matrícula realizada com sucesso.");
    }

    public void matricularDisciplinaOptativa(Turma turma) {
        if (!turma.getDisciplina().isOptativa()) {
            System.out.println("Esta disciplina não é optativa.");
            return;
        }

        if (optativasMaximasAtingida()) {
            System.out.println("Você já atingiu o limite de disciplinas optativas.");
            return;
        }

        if (turma.getAlunosMatriculados().size() >= turma.getDisciplina().getNUMERO_MAXIMO_ALUNOS()) {
            System.out.println("A turma já atingiu o limite máximo de alunos.");
            return;
        }

        this.turmas.add(turma);
        turma.addAluno(this);
        System.out.println("Matrícula realizada com sucesso.");
    }

    public void cancelarMatricula(Turma turma) {
        if (!this.turmas.contains(turma)) {
            System.out.println("Você não está matriculado nesta disciplina.");
            return;
        }

        this.turmas.remove(turma);
        turma.removeAluno(this);
        System.out.println("Matrícula cancelada com sucesso.");
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

    private boolean optativasMaximasAtingida() {
    int numeroOptativas = 0;
    for(Turmas turma:turmas) {
        if(turma.isOptativa()) {
            numeroOptativas++;
            }
        }
        return numeroOptativas < 2? false:true;
    }

    private boolean obrigatoriasMaximasAtingidas() {
        int numeroObrigatorias = 0;
        for(Turmas turma:turmas) {
            if(!turma.isOptativa()) {
                numeroOptativas++;
            }
        }
        return numeroObrigatorias < 4? false:true;

    }

}
