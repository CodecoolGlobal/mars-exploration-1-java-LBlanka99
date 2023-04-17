package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Symbol;

import java.util.Random;

public class ShapeGenerator {
    private int amount;
    private Symbol symbol;
    private Random random;

    public ShapeGenerator(int amount, Symbol symbol) {
        this.amount = amount;
        this.symbol = symbol;
        this.random = new Random();
    }
}
