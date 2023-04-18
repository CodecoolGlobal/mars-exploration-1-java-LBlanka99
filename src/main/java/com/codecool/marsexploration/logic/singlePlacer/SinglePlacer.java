package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.data.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SinglePlacer {

    private Symbol toPlace;
    private Symbol placeNear;
    private int amount;
    private Map map;
    private Random random;

    public SinglePlacer(Symbol toPlace, int amount, Map map) {
        this.toPlace = toPlace;
        this.amount = amount;
        random = new Random();
        this.map = map;
        switch (toPlace) {
            case WATER -> placeNear = Symbol.PIT;
            case MINERAL -> placeNear = Symbol.MOUNTAIN;
        }
    }

    public void placeSymbols() {
        int placedCounter = 0;

        List<Coordinate> possiblePlaces = getPlaceableCoordinates();
        if (possiblePlaces.size() < amount) {
            amount = possiblePlaces.size();
        }

        while (placedCounter < amount) {
            int randomIndex = random.nextInt(possiblePlaces.size());
            Coordinate randomCoordinate = possiblePlaces.get(randomIndex);
            map.setCoordinate(randomCoordinate, toPlace);
            possiblePlaces.remove(randomIndex);
            placedCounter++;
        }
    }

    private boolean isValidPlacement(Coordinate coordinate) {
        if (map.getMap()[coordinate.x()][coordinate.y()] != ' ') {
            return false;
        }
        for (int i = coordinate.x() - 1; i <= coordinate.x() + 1; i++) {
            for (int j = coordinate.y() - 1; j <= coordinate.y() + 1; j++) {
                if (!(i < 0 || j < 0 || i >= map.getWidth() || j >= map.getWidth())) {
                    if (map.getMap()[i][j] == placeNear.getSymbol()) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private List<Coordinate> getPlaceableCoordinates () {
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        for(int i = 0; i < map.getWidth(); i++){
            for(int j = 0; j < map.getWidth(); j++){
                if(isValidPlacement(new Coordinate(i, j))){
                    possibleCoordinates.add(new Coordinate(i, j));
                }
            }
        }
        return possibleCoordinates;
    }
}