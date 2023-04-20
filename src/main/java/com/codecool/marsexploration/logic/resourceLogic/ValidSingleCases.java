package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;

import java.util.ArrayList;
import java.util.List;

public class ValidSingleCases {

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

    public List<Coordinate> getPlaceableCoordinates(Map map, Symbol placeNear) {
        List<Coordinate> possibleCoordinates = new ArrayList<>();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (isValidPlacement(new Coordinate(i, j), map, placeNear)) {
                    possibleCoordinates.add(new Coordinate(i, j));
                }
            }
        }
        return possibleCoordinates;
    }
}
