package org.example.Models;

import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int CREDITOS;
    private int CARGA_HORARIA;
    private List<Disciplina> disciplinas;

    public Curso(int id, String nome, int CREDITOS, int CARGA_HORARIA, List<Disciplina> disciplina) {
        this.id = id;
        this.nome = nome;
        this.CREDITOS = CREDITOS;
        this.CARGA_HORARIA = CARGA_HORARIA;
        this.disciplinas = disciplina;
    }

    public Curso(String[] dadosCurso) {
        this.id = Integer.parseInt(dadosCurso[0]);
        this.nome = dadosCurso[1];
        this.CREDITOS = Integer.parseInt(dadosCurso[2]);
    }

    public void adicionarDisciplina(Disciplina disciplina) {

    }

    public void removerDisciplina(int idDisciplina) {

    }

    public List<Disciplina> getDisciplinasObrigatorias() {
        return this.getDisciplinas()
                .stream()
                .filter(disciplina -> !disciplina.isOptativa())
                .toList();
    }


    public List<Disciplina> getDisciplinasOptativas() {
        return this.getDisciplinas()
                .stream()
                .filter(Disciplina::isOptativa)
                .toList();
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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplinaById(int id) {
        if (this.disciplinas == null || this.disciplinas.isEmpty()) {
            return null;
        }
        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + CREDITOS + ";" + CARGA_HORARIA + ";" + disciplinas;
    }
}
