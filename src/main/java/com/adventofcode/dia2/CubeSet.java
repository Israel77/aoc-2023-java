package com.adventofcode.dia2;

public record CubeSet(Integer red, Integer green, Integer blue) {
    public boolean validar() {
        return this.red() <= 12
                && this.green() <= 13
                && this.blue() <= 14;
    }

}
