package com.adventofcode.dia2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InterpretarGameTest {
    @Test
    void deve_interpretar_digito_unico() {
        var testString = "Game 1: red 3; blue 5, red 6";
        var parser = new InterpretarGame();

        var esperado = new Game(1, "red 3; blue 5, red 6");
        var resultado = parser.parse(testString).get();

        assertEquals(esperado, resultado);
    }

    @Test
    void deve_interpretar_multiplos_digitos() {
        var testString = "Game 15: red 3; blue 5, red 6";
        var parser = new InterpretarGame();

        var esperado = new Game(15, "red 3; blue 5, red 6");
        var resultado = parser.parse(testString).get();

        assertEquals(esperado, resultado);
    }

    @Test
    void deve_poder_retornar_string_vazia() {
        var testString = "Game 15:";
        var parser = new InterpretarGame();

        var esperado = new Game(15, "");
        var resultado = parser.parse(testString).get();

        assertEquals(esperado, resultado);
    }
}
