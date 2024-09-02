package org.example;

import org.example.Models.Pessoa;
import org.example.Models.Secretaria;
import org.example.Utils.Arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Pessoa pessoa = new Pessoa(1,"augusto","pppppp");
        Arquivos.armazenarValores(pessoa, "file-path-direto-da-maquina");*/
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
        String opcao = "";
        System.out.println("Qual tarefa você vai realizar");
        System.out.println("1 - Gerar Curriculo");
        System.out.println("2 - Cadastrar Curso");
        System.out.println("3 - Voltar");
        System.out.println("FIM - Sair");
        opcao = scanner.next();
        switch (opcao){
            case "1":
                System.out.println("Deve gerar Curriculo ");
              /*  secretaria.gerarCurriculo();*/
                break;
            case "2":
                System.out.println("Deve Cadastrar Curso ");
                secretaria.cadastrarCurso();
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