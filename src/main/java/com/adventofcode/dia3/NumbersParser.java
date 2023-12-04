package com.adventofcode.dia3;

import java.util.HashSet;
import java.util.Set;

import com.adventofcode.Parser;

public class NumbersParser implements Parser<Set<NumberToken>> {

    @Override
    public Set<NumberToken> parse(String input) {
        var result = new HashSet<NumberToken>();

        Iterable<String> iterableLines = () -> input.lines().iterator();

        var row = 0;
        for (String lineString : iterableLines) {
            result.addAll(parseLine(lineString, row));
            ++row;
        }

        return result;
    }

    public Set<NumberToken> parseLine(String line, int row) {

        var result = new HashSet<NumberToken>();

        var index = 0;
        while (index < line.length()) {
            if (Character.isDigit(line.charAt(index))) {
                var number = parseSingleNumber(line.substring(index),
                        row,
                        index);

                index = number.end() + 1;
                result.add(number);
            } else {
                ++index;
            }

        }

        return result;
    }

    private NumberToken parseSingleNumber(String numberString,
            int row,
            int startIndex) {
        var resultValue = new StringBuffer();

        var offset = 0;
        var c = numberString.charAt(offset);

        while (Character.isDigit(c)) {
            ++offset;
            resultValue.append(c);

            try {
                c = numberString.charAt(offset);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        return new NumberToken(
                Integer.parseInt(resultValue.toString()),
                row,
                startIndex,
                startIndex + offset - 1);

    }

}
