package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ShapeGenerator {
    private Random random;

    public ShapeGenerator() {
        this.random = new Random();
    }

    public List<Coordinate> generateShape(int amount) {
        char[][] area = new char[amount][amount];

        int prevRandomX = random.nextInt(amount);
        int prevRandomY = random.nextInt(amount);
        List<Coordinate> results = new ArrayList<>();

        area[prevRandomX][prevRandomY] = 'x';
        results.add(new Coordinate(prevRandomX, prevRandomY));
        int placedCounter = 1;

        while (placedCounter < amount){
            List<Coordinate> emptyNeighbours = new ArrayList<>();
            for(int i = prevRandomX - 1; i <= prevRandomX + 1; i++){
                for(int j = prevRandomY - 1; j <= prevRandomY + 1; j++){
                    if(!(i < 0 || j < 0 || i >= amount || j >= amount)){
                        if(area[i][j] == 0){
                            emptyNeighbours.add(new Coordinate(i, j));
                        }
                    }
                }
            }
            if(!emptyNeighbours.isEmpty()){
                int randomIndex = random.nextInt(emptyNeighbours.size());
                prevRandomX = emptyNeighbours.get(randomIndex).x();
                prevRandomY = emptyNeighbours.get(randomIndex).y();
                area[prevRandomX][prevRandomY] = 'x';
                results.add(new Coordinate(prevRandomX, prevRandomY));
                placedCounter++;
            }
            else{
                int randomIndex = random.nextInt(results.size());
                prevRandomX = results.get(randomIndex).x();
                prevRandomY = results.get(randomIndex).y();
            }
        }
        return results;
    }
}
