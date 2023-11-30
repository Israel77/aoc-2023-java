package com.adventofcode;

@FunctionalInterface
public interface Parser<T> {
    T parse(String input);
}
