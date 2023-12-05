package com.adventofcode.dia3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Dia3Parte1Test {
    @Test
    void testar_solucao() {
        var testString = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..""";

        var esperado = "4361";

        var solucao = new Dia3Parte1().resolver(testString);

        assertEquals(esperado, solucao);
    }
}
