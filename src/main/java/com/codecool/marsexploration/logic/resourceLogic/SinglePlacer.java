package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.util.RandomPicker;

import java.util.List;

public abstract class SinglePlacer {
    protected Symbol toPlace;
    protected Symbol placeNear;
    private int amount;
    private final Map map;
    private final ValidSingleCases singleValidator;


    public SinglePlacer(int amount, Map map) {
        this.amount = amount;
        this.map = map;
        singleValidator = new ValidSingleCases();
    }

    public void placeSymbolsRandomlyToThePossiblePlaces() {
        List<Coordinate> possiblePlaces = singleValidator.getPlaceableCoordinates(map, placeNear);

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


}
