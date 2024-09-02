package org.example.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Arquivos {
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
