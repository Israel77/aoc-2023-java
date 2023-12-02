package com.adventofcode.dia2;

import java.util.Optional;
import java.util.regex.Pattern;

import com.adventofcode.Parser;

public class InterpretarGame implements Parser<Optional<Game>> {

    @Override
    public Optional<Game> parse(String input) {
        Pattern gameInput = Pattern.compile("^Game (\\d+): ?(.*)$");
        var matcher = gameInput.matcher(input);

        if (matcher.matches()) {
            int id = Integer.parseInt(matcher.group(1));
            String gameInfo = matcher.group(2);

            return Optional.of(new Game(id, gameInfo));

        } else {
            return Optional.empty();
        }

    }

}
