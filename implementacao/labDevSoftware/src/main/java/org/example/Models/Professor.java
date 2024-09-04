package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    public Professor(int id, String nome, String senha) {
        super(id, nome, senha);
    }

    public List<Aluno> visualizarAlunosMatriculados(){
//        Aluno Aluno = new Aluno();
        List<Aluno> list = new ArrayList<>();
//        list.add(Aluno);
        return  list;
    }

    @Override
    public String toString() {
        return getId() + ";" + getNome() + ";" + getSenha();
    }
}
