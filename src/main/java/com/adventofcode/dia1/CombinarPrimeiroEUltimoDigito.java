package com.adventofcode.dia1;

import java.util.Optional;
import com.adventofcode.Parser;

public class CombinarPrimeiroEUltimoDigito implements Parser<Optional<Integer>> {

    @Override
    public Optional<Integer> parse(String input) {
        var digitos = input.chars().filter(Character::isDigit).toArray();

        if (digitos.length == 0)
            return Optional.empty();

        var primeiroDigito = Character.toString(digitos[0]);
        var ultimoDigito = Character.toString(digitos[digitos.length - 1]);

        try {
            return Optional.of(Integer.parseInt(primeiroDigito + ultimoDigito));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
