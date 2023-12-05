package com.adventofcode.dia3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Schematic(List<String> data, int rows, int columns) {

    public Set<Token> getNumbersAndSymbols() {
        var result = new HashSet<Token>();
        var numbersParser = new NumbersParser();
        var symbolsParser = new SymbolsParser();

        for (int row = 0; row < rows; row++) {
            var line = data.get(row);
            result.addAll(numbersParser.parseLine(line, row));
            result.addAll(symbolsParser.parseLine(line, row));
        }

        return result;
    }
}
