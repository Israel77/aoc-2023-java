package com.adventofcode.dia3;

import java.util.HashSet;
import java.util.Set;

public record SymbolToken(char value, int row, int pos) implements Token {

    public Set<Pair<Integer>> getAdjacent(int maxRow, int maxColumn) {
        var result = new HashSet<Pair<Integer>>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                var x = pos + j;
                var y = row + i;

                if (!(x == pos && y == row)
                        && x < maxColumn
                        && y < maxRow) {
                    result.add(new Pair<Integer>(y, x));
                }
            }
        }

        return result;
    }

}
