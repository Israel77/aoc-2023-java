package com.adventofcode.dia3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class SymbolTokenTest {
    @Test
    void deve_calcular_todos_os_vizinhos() {
        var testSymbol = new SymbolToken('+', 1, 1);

        var esperado = Set.of(
                new Pair<Integer>(0, 0),
                new Pair<Integer>(0, 1),
                new Pair<Integer>(0, 2),
                new Pair<Integer>(1, 0),
                new Pair<Integer>(1, 2),
                new Pair<Integer>(2, 0),
                new Pair<Integer>(2, 1),
                new Pair<Integer>(2, 2));

        var resultado = testSymbol.getAdjacent(5, 5);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

    @Test
    void deve_obedecer_os_limites_passados() {
        var testSymbol = new SymbolToken('+', 1, 1);

        var esperado = Set.of(
                new Pair<Integer>(0, 0),
                new Pair<Integer>(0, 1),
                new Pair<Integer>(1, 0),
                new Pair<Integer>(2, 0),
                new Pair<Integer>(2, 1));

        var resultado = testSymbol.getAdjacent(5, 2);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

}
