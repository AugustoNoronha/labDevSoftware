package org.example.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Professor(int id, String nome, String senha) {
        super(nome, senha);
        this.id = id;
    }

    public Professor() {
    }

    public List<Aluno> visualizarAlunosMatriculados() {
//        Aluno Aluno = new Aluno();
        List<Aluno> list = new ArrayList<>();
//        list.add(Aluno);
        return list;
    }

}
