package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Pessoa{
    public Secretaria(int id, String nome, String senha) {
        super(id, nome, senha);
    }

    public void gerarCurriculo(){

    }

    public Curso cadastrarCurso(){
        List<Disciplina> disciplinas = new ArrayList<>();
        Curso curso = new Curso(1,"x",20,70,disciplinas);
        return  curso;
    }


}
