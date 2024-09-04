package org.example.Models;

import org.example.Utils.Arquivos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Secretaria extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Secretaria(String nome, String senha, int id) {
        super(nome, senha);
        this.id = id;
    }

    public Secretaria() {
    }

    public Turmas gerarCurriculo(String ano, String semestre, Disciplina disciplina, Professor professor, List<Aluno> alunos) {
        if (alunos.size() >= 3 && alunos.size() <= 60) {
            Turmas turma = new Turmas(professor, disciplina, alunos, semestre, ano);
            Arquivos.armazenarValores(turma, "C:\\temp\\turmas.txt");
            System.out.println("Curriculo gerado com sucesso");
            System.out.println("[ " + turma.getAno() + "/" + turma.getSemestre() + "," + turma.getProfessor().getNome() + "," + turma.getDisciplina().getNome() + " ]");

            return turma;
        } else if (alunos.size() < 3) {
            System.out.println("Quantidade de alunos insuficiente");
            return null;
        } else {
            System.out.println("Quantidade de alunos exedida");
            return null;
        }

    }

    public Curso cadastrarCurso(String nome, int creditos, int cargaHoraria, List<Disciplina> diciplinas) {
        Curso curso = new Curso(1, nome, creditos, 70, diciplinas);
        Arquivos.armazenarValores(curso, "C:\\temp\\curso.txt");
        System.out.println("Curso inserido com sucesso");
        System.out.println("[ " + curso.getNome() + " , " + curso.getCREDITOS() + " ]");
        return curso;
    }


}
