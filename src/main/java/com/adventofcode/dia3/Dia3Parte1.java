package com.adventofcode.dia3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.adventofcode.Solucao;

public class Dia3Parte1 implements Solucao {

    public static void main(String[] args) {
        var solver = new Dia3Parte1();
        var filePath = "entradas/dia-3.txt";

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
        var schematicParser = new SchematicParser();
        var numbersParser = new NumbersParser();
        var symbolsParser = new SymbolsParser();

        var schematic = schematicParser.parse(input);
        var symbols = symbolsParser.parse(input);
        var numbers = numbersParser.parse(input);

        var adjacentToSymbols = symbols.stream()
                .flatMap(s -> s.getAdjacent(
                        schematic.rows(),
                        schematic.columns())
                        .stream())
                .collect(Collectors.toSet());

        return Integer.toString(numbers.stream()
                .filter(n -> adjacentToSymbols.stream().anyMatch(
                        p -> p.first() == n.row()
                                && p.second() >= n.start()
                                && p.second() <= n.end()))
                .mapToInt(n -> n.value())
                .sum());

    }

}
