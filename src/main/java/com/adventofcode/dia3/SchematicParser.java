package com.adventofcode.dia3;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.adventofcode.Parser;

public class SchematicParser implements Parser<Schematic> {

    @Override
    public Schematic parse(String input) {
        // TODO: Fazer parsing mais estrito e adicionar testes

        var data = input.lines().collect(Collectors.toCollection(ArrayList::new));
        var rows = data.size();
        var columns = data.get(0).length();

        return new Schematic(data, rows, columns);
    }

}
