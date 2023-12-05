package com.adventofcode.dia2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventofcode.Parser;

public class ExtrairQuantidades implements Parser<List<CubeSet>> {

    @Override
    public List<CubeSet> parse(String gameInfo) {
        var resultado = new ArrayList<CubeSet>();

        Matcher matcherPrincipal = Pattern.compile("((?:(\\d)+ [a-z]+(?:, )?)+)(?:;|$)").matcher(gameInfo);

        Pattern padraoRed = Pattern.compile("(\\d+) red(?:,|;|$)");
        Pattern padraoGreen = Pattern.compile("(\\d+) green(?:,|;|$)");
        Pattern padraoBlue = Pattern.compile("(\\d+) blue(?:,|;|$)");

        while (matcherPrincipal.find()) {
            var entrada = matcherPrincipal.group(1);

            var matcherRed = padraoRed.matcher(entrada);
            var matcherBlue = padraoBlue.matcher(entrada);
            var matcherGreen = padraoGreen.matcher(entrada);

            var red = 0;
            var green = 0;
            var blue = 0;

            if (matcherRed.find()) {
                red = Integer.parseInt(matcherRed.group(1));
            }
            if (matcherGreen.find()) {
                green = Integer.parseInt(matcherGreen.group(1));
            }
            if (matcherBlue.find()) {
                blue = Integer.parseInt(matcherBlue.group(1));
            }

            resultado.add(new CubeSet(red, green, blue));
        }

        return resultado;
    }

}
