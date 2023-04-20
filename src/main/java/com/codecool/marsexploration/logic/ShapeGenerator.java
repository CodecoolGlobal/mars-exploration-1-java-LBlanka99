package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codecool.marsexploration.util.RandomPicker.pickRandomElement;

public class ShapeGenerator {
    private Random random;

    public ShapeGenerator() {
        this.random = new Random();
    }

    public List<Coordinate> generateShape(int amount) {
        char[][] area = new char[amount][amount];

        Coordinate randomCoordinate = new Coordinate(random.nextInt(amount), random.nextInt(amount));
        List<Coordinate> results = new ArrayList<>();

        area[randomCoordinate.x()][randomCoordinate.y()] = 'x';
        results.add(new Coordinate(randomCoordinate.x(), randomCoordinate.y()));
        int placedCounter = 1;

        while (placedCounter < amount){
            List<Coordinate> emptyNeighbours = getEmptyNeighbours(amount, area, randomCoordinate.x(), randomCoordinate.y());

            if(!emptyNeighbours.isEmpty()){
                randomCoordinate = pickRandomElement(emptyNeighbours);
                area[randomCoordinate.x()][randomCoordinate.y()] = 'x';
                results.add(new Coordinate(randomCoordinate.x(), randomCoordinate.y()));
                placedCounter++;
            }
            else{
                randomCoordinate = pickRandomElement(results);
            }
        }
        return results;
    }

    private static List<Coordinate> getEmptyNeighbours(int amount, char[][] area, int prevRandomX, int prevRandomY) {
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
        return emptyNeighbours;
    }
}
