package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Dia1Parte2Test {
    @Test
    void testar_solucao() {
        String testString = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """;

        var solver = new Dia1Parte2();

        var expected = "281";

        assertEquals(expected, solver.resolver(testString));

    }
}
