package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.util.RandomPicker;

import java.util.ArrayList;
import java.util.List;

public abstract class SinglePlacer {
    protected Symbol toPlace;
    private int amount;
    private Map map;
    protected Symbol placeNear;


    public SinglePlacer(int amount, Map map) {
        this.amount = amount;
        this.map = map;
    }

    public void placeSymbolsRandomly() {
        List<Coordinate> possiblePlaces = getPlaceableCoordinates(map, placeNear);

        if (possiblePlaces.size() < amount) {
            amount = possiblePlaces.size();
        }

        placeSymbolsRandomly(possiblePlaces, amount, toPlace, map);
    }

    private void placeSymbolsRandomly(List<Coordinate> possiblePlaces, int amount, Symbol toPlace, Map map) {
        int placedCounter = 0;
        while (placedCounter < amount) {
            Coordinate randomCoordinate = RandomPicker.pickRandomElement(possiblePlaces);
            map.setCoordinate(randomCoordinate, toPlace);
            possiblePlaces.remove(randomCoordinate);
            placedCounter++;
        }
    }

    public boolean isValidPlacement(Coordinate coordinate, Map map, Symbol placeNear) {
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

    private List<Coordinate> getPlaceableCoordinates (Map map, Symbol placeNear) {
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        for(int i = 0; i < map.getWidth(); i++){
            for(int j = 0; j < map.getWidth(); j++){
                if(isValidPlacement(new Coordinate(i, j), map, placeNear)){
                    possibleCoordinates.add(new Coordinate(i, j));
                }
            }
        }
        return possibleCoordinates;
    }
}
