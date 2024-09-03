package org.example;

import org.example.Models.*;
import org.example.Models.Enums.Status;
import org.example.Utils.Arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String entrada = "";
            entrada = gerarMenuUsuarios(sc);
    }

    public static String gerarMenuUsuarios(Scanner scanner){
        String opcao = "";
        System.out.println("Qual seu tipo de usuario");
        System.out.println("1 - Secretaria");
        System.out.println("2 - Aluno");
        System.out.println("FIM - Sair");
        opcao = scanner.next();
        switch (opcao){
            case "1":
                Secretaria secretaria = new Secretaria(1,"secretaria","123456");
                System.out.println("Secretaria selecionaou ");
                gerarMenuSecretaria(scanner,secretaria);
                break;
            case "2":
                System.out.println("Usuario selecionaou ");
                break;
            case "FIM":
                break;
            default:
                gerarMenuUsuarios(scanner);
                break;
        }
        return opcao;
    }

    public static String gerarMenuSecretaria(Scanner scanner, Secretaria secretaria){
        List<Disciplina> listDisciplina = new ArrayList<>();
        Disciplina disciplina1 = new Disciplina(1,"A",25,false,50,listDisciplina,60, Status.ATIVA);
        Disciplina disciplina2 = new Disciplina(2,"B",25,false,50,listDisciplina,60, Status.ATIVA);
        Disciplina disciplina3 = new Disciplina(3,"C",25,false,50,listDisciplina,60, Status.ATIVA);

        listDisciplina.add(disciplina1);
        listDisciplina.add(disciplina2);
        listDisciplina.add(disciplina3);

        List<Professor> listProfessores = new ArrayList<>();
        Professor professor1 = new Professor(1,"Cleia","123");
        Professor professor2 = new Professor(1,"Arthur","123");
        Professor professor3 = new Professor(1,"Joao","123");
        listProfessores.add(professor1);
        listProfessores.add(professor2);
        listProfessores.add(professor3);

        List<Aluno> listAlunos = new ArrayList<>();
        Aluno aluno1 = new Aluno(1,"Romulo","123",20,null,null);
        Aluno aluno2 = new Aluno(1,"Pedro","123",20,null,null);
        Aluno aluno3 = new Aluno(1,"Lucas","123",20,null,null);
        listAlunos.add(aluno1);
        listAlunos.add(aluno2);
        listAlunos.add(aluno3);

        String opcao = "";
        System.out.println("Qual tarefa você vai realizar");
        System.out.println("1 - Gerar Curriculo");
        System.out.println("2 - Cadastrar Curso");
        System.out.println("3 - Voltar");
        System.out.println("FIM - Sair");
        opcao = scanner.next();
        int count = 0;
        switch (opcao){
            case "1":
                System.out.println("Qual ano do curriculo ? ");
                String ano = scanner.next();
                System.out.println("Qual o semestre ? ");
                String semestre = scanner.next();
                System.out.println("Qual a disciplina ? ");
                count = 0;
                while (listDisciplina.size() > count){
                    System.out.println(count +  " - " + listDisciplina.get(count).getNome());
                    count ++;
                }
                int item = scanner.nextInt();
                Disciplina selecionada = listDisciplina.get(item);

                System.out.println("Qual o professor ? ");
                count = 0;
                while (listProfessores.size() > count){
                    System.out.println(count +  " - " + listProfessores.get(count).getNome());
                    count ++;
                }
                item = scanner.nextInt();
                Professor profSelecionado = listProfessores.get(item);
                secretaria.gerarCurriculo(ano,semestre,selecionada,profSelecionado,listAlunos);
                gerarMenuUsuarios(scanner);
                break;
            case "2":
                System.out.println("Qual o nome do curso ? ");
                String nomeCurso = scanner.next();
                System.out.println("Quantos creditos este curso possui ? ");
                int creditosCurso = scanner.nextInt();
                System.out.println("Qual a carga horaria deste curso ? ");
                int cargaHoraria = scanner.nextInt();
                count = 0;
                List<Disciplina> diciplinasCurso = new ArrayList<>();
                while (listDisciplina.size() > count){
                    System.out.println(count +  " - " + listDisciplina.get(count).getNome());
                    count ++;
                }
                System.out.println("Digite os numeros para dicionar a disciplina / para concluir 'DONE'");
                String entrada = scanner.next();
                while (!entrada.equals("DONE")){
                    System.out.println("Proximo ? / para concluir 'DONE'");
                    diciplinasCurso.add(listDisciplina.get(Integer.parseInt(entrada)));
                    entrada = scanner.next();

                }

                secretaria.cadastrarCurso(nomeCurso,creditosCurso,cargaHoraria,diciplinasCurso);
                break;
            case "3":
                gerarMenuUsuarios(scanner);
                break;
            case "FIM":
                break;
            default:
                gerarMenuSecretaria(scanner,secretaria);
                break;
        }
        return opcao;
    }


    //funçao padrão de armazenamento de valores
    public static <T> void armazenarValores(T obj, String caminhoArquivo) {
        StringBuilder registro = new StringBuilder();
        Field[] campos = obj.getClass().getDeclaredFields();

        try {
            for (Field campo : campos) {
                campo.setAccessible(true);
                Object valorCampo = campo.get(obj);
                if (valorCampo != null) {
                    registro.append(valorCampo.toString());
                }
                registro.append(";");
            }

            if (registro.length() > 0 && registro.charAt(registro.length() - 1) == ';') {
                registro.setLength(registro.length() - 1);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
                writer.write(registro.toString());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

        } catch (IllegalAccessException e) {
            System.out.println("Erro ao acessar os campos do objeto: " + e.getMessage());
        }
    }
}