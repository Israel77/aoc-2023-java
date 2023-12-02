package com.adventofcode.dia2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.adventofcode.Parser;
import com.adventofcode.Solucao;

public class Parte1 implements Solucao {
    Parser parser;

    public static void main(String[] args) {
        var solver = new Parte1();
        var filePath = "input/day-1.txt";

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            String content = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining("\n"));

            System.out.println(solver.resolver(content));
        } catch (Exception e) {
            System.out.println("Não foi possível abrir o arquivo: " + filePath);
        }
    }

    @Override
    public String resolver(String input) {
        // TODO
        return new String();
    }

}
