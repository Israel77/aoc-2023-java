package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Parte1Test {
    @Test
    void resolver_exemplo() {
        String testString = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                                """;

        var solucao = new Parte1();

        var esperado = "142";

        assertEquals(esperado, solucao.resolver(testString));
    }
}
