package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.Random;
import java.util.List;

public class ShapeGenerator {
    private int amount;
    private char[][] area;
    private Random random;

    public ShapeGenerator(int amount) {
        this.amount = amount;
        this.random = new Random();
        this.area = new char[amount][amount];
    }

    public List<Coordinate> generateShape() {
        int randomX = random.nextInt(amount);
        int randomY = random.nextInt(amount);

        area[randomX][randomY] = 'x';

        int placedCounter = 1;

        while (placedCounter < amount){

        }
    }
}
