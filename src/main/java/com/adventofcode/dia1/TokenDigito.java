package com.adventofcode.dia1;

import java.util.regex.Pattern;

/**
 * Objeto representando um padrão presente no arquivo de entrada
 */
public record TokenDigito(Pattern palavra, String valor, Integer tamanho) {

    /**
     * Construtor simplificado, usado para buscar no início de uma string
     * 
     * @param palavra a palavra a ser buscada no início da string
     * @param valor o valor que deve substituir a palavra encontrada
     */
    public TokenDigito(String palavra, String valor) {
        this(Pattern.compile("^" + palavra), valor, palavra.length());
    }

}
