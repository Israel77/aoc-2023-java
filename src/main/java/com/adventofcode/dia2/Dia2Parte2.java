package com.adventofcode.dia2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.adventofcode.Solucao;
import com.adventofcode.dia1.ExtrairQuantidades;

public class Dia2Parte2 implements Solucao {
    InterpretarGame interpretarGame = new InterpretarGame();
    ExtrairQuantidades extrairQuantidades = new ExtrairQuantidades();

    public static void main(String[] args) {
        var solver = new Dia2Parte2();
        var filePath = "entradas/dia-2.txt";

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
        return Integer.toString(input.lines()
                .map(line -> interpretarGame.parse(line).get())
                .map(game -> extrairQuantidades.parse(game.gameInfo()))
                .map(list -> list.stream()
                        .reduce((a, b) -> CubeSet.max(a, b))
                        .get())
                .mapToInt(cubes -> cubes.power())
                .sum());
    }

}
