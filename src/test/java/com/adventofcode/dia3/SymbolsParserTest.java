package com.adventofcode.dia3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class SymbolsParserTest {
    @Test
    void deve_encontrar_simbolos() {
        var testString = "+*$#";
        var parser = new SymbolsParser();

        var esperado = Set.of(
                new SymbolToken('+', 0, 0),
                new SymbolToken('*', 0, 1),
                new SymbolToken('$', 0, 2),
                new SymbolToken('#', 0, 3));

        Set<SymbolToken> resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

    @Test
    void deve_ignorar_numeros_e_pontos() {
        var testString = "12+..*.4.$.#.5";
        var parser = new SymbolsParser();

        var esperado = Set.of(
                new SymbolToken('+', 0, 2),
                new SymbolToken('*', 0, 5),
                new SymbolToken('$', 0, 9),
                new SymbolToken('#', 0, 11));

        Set<SymbolToken> resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

    @Test
    void deve_processar_multiplas_linhas() {
        var testString = """
                123..+
                *.$..#
                    """;
        var parser = new SymbolsParser();

        var esperado = Set.of(
                new SymbolToken('+', 0, 5),
                new SymbolToken('*', 1, 0),
                new SymbolToken('$', 1, 2),
                new SymbolToken('#', 1, 5));

        Set<SymbolToken> resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));

    }
}
