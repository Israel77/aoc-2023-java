package com.adventofcode.dia3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SchematicParserTest {
    @Test
    void deve_conseguir_extrair_dados_de_string() {
        var testString = """
                1....2.3
                +..2..5.
                *..4..89
                    """;
        var esperado = new Schematic(List.of(
                "1....2.3",
                "+..2..5.",
                "*..4..89"), 3, 8);
        var parser = new SchematicParser();

        assertEquals(esperado, parser.parse(testString));
    }
}
