package com.codecool.marsexploration.data;

public enum Symbol {
    WATER('~'),
    MOUNTAIN('^'),
    PIT('#'),
    MINERAL('*');

    private char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
