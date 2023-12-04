package com.adventofcode.dia3;

import java.util.HashSet;
import java.util.Set;

import com.adventofcode.Parser;

public class SymbolsParser implements Parser<Set<SymbolToken>> {

    @Override
    public Set<SymbolToken> parse(String input) {
        var result = new HashSet<SymbolToken>();

        Iterable<String> iterableLines = () -> input.lines().iterator();

        var row = 0;
        for (String lineString : iterableLines) {
            result.addAll(parseLine(lineString, row));
            ++row;
        }
        return result;
    }

    public Set<SymbolToken> parseLine(final String line, int row) {
        final var result = new HashSet<SymbolToken>();

        for (int index = 0; index < line.length(); index++) {
            final var c = line.charAt(index);

            if (!Character.isDigit(c) && c != '.') {
                result.add(new SymbolToken(c, row, index));
            }
        }

        return result;
    }

}
