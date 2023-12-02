package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TraduzirPalavrasParaDigitosTest {
    @Test
    void transformar_palavras_em_digitos() {
        var testString = "two1nine";
        var parser = new TraduzirPalavrasParaDigitos();

        var esperado = "219";

        assertEquals(esperado, parser.parse(testString));
    }

    @Test
    void priorizar_ordem_das_palavras() {
        var testString = "eightwothree";
        var parser = new TraduzirPalavrasParaDigitos();

        var esperado = "8wo3";

        assertEquals(esperado, parser.parse(testString));
    }
}
