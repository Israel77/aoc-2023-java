package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.adventofcode.dia2.CubeSet;
import com.adventofcode.dia2.ExtrairQuantidades;

public class ExtrairQuantidadesTest {
    @Test
    void deve_extrair_quantidade_a_partir_de_string() {
        var testString = "3 red, 1 green, 5 blue";
        var parser = new ExtrairQuantidades();

        var esperado = new ArrayList<CubeSet>();
        esperado.add(new CubeSet(3, 1, 5));

        assertEquals(esperado, parser.parse(testString));
    }

    @Test
    void a_ordem_dos_elementos_nao_deve_importar() {
        var testString = "3 red, 5 blue, 1 green";
        var parser = new ExtrairQuantidades();

        var esperado = new ArrayList<CubeSet>();
        esperado.add(new CubeSet(3, 1, 5));

        assertEquals(esperado, parser.parse(testString));
    }

    @Test
    void elementos_faltando_devem_ser_substituidos_por_zero() {
        var testString = "3 red";
        var parser = new ExtrairQuantidades();

        var esperado = new ArrayList<CubeSet>();
        esperado.add(new CubeSet(3, 0, 0));

        assertEquals(esperado, parser.parse(testString));

    }

    @Test
    void deve_conseguir_processar_multiplos_digitos() {
        var testString = "33 red, 15 green, 101 blue";
        var parser = new ExtrairQuantidades();

        var esperado = new ArrayList<CubeSet>();
        esperado.add(new CubeSet(33, 15, 101));

        assertEquals(esperado, parser.parse(testString));

    }

    @Test
    void deve_conseguir_extrair_multiplas_sequencias() {
        var testString = "33 red, 15 green, 101 blue; 1 red, 1 green, 1 blue; 3 green";
        var parser = new ExtrairQuantidades();

        var esperado = new ArrayList<CubeSet>();
        esperado.add(new CubeSet(33, 15, 101));
        esperado.add(new CubeSet(1, 1, 1));
        esperado.add(new CubeSet(0, 3, 0));

        assertEquals(esperado, parser.parse(testString));

    }
}
