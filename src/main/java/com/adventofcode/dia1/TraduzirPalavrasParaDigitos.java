package com.adventofcode.dia1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.adventofcode.Parser;

public class TraduzirPalavrasParaDigitos implements Parser<String> {

    private List<TokenDigito> tabelaDeTraducao;

    public TraduzirPalavrasParaDigitos() {
        tabelaDeTraducao = new ArrayList<TokenDigito>();

        tabelaDeTraducao.add(new TokenDigito("one", "1"));
        tabelaDeTraducao.add(new TokenDigito("two", "2"));
        tabelaDeTraducao.add(new TokenDigito("three", "3"));
        tabelaDeTraducao.add(new TokenDigito("four", "4"));
        tabelaDeTraducao.add(new TokenDigito("five", "5"));
        tabelaDeTraducao.add(new TokenDigito("six", "6"));
        tabelaDeTraducao.add(new TokenDigito("seven", "7"));
        tabelaDeTraducao.add(new TokenDigito("eight", "8"));
        tabelaDeTraducao.add(new TokenDigito("nine", "9"));

    }

    @Override
    public String parse(String input) {
        StringBuffer resultado = new StringBuffer();

        var i = 0;

        while (true) {
            if (i >= input.length()) {
                break;
            }

            var substitituicao = tentarSubstituir(input, i);

            if (substitituicao.isPresent()) {
                var token = substitituicao.get();
                resultado.append(token.valor());
                i += token.tamanho();
            } else {
                resultado.append(input.charAt(i));
                ++i;
            }
        }

        return resultado.toString();
    }

    private Optional<TokenDigito> tentarSubstituir(String input, int i) {
        for (var token : tabelaDeTraducao) {
            if (token.palavra().matcher(input.substring(i)).find()) {
                return Optional.of(token);
            }
        }

        return Optional.empty();
    }


}
