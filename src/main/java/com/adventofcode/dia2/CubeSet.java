package com.adventofcode.dia2;

public record CubeSet(int red, int green, int blue) {
    public boolean validar() {
        return this.red() <= 12
                && this.green() <= 13
                && this.blue() <= 14;
    }

    public int power() {
        return red * green * blue;
    }

    public static CubeSet max(CubeSet a, CubeSet b) {
        return new CubeSet(
                Integer.max(a.red(), b.red()),
                Integer.max(a.green(), b.green()),
                Integer.max(a.blue(), b.blue()));
    }
}
