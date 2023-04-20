package com.codecool.marsexploration.logic;


import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;

import java.util.ArrayList;
import java.util.List;

import static com.codecool.marsexploration.util.RandomPicker.pickRandomElement;

public class ShapePlacer {
    private final Map map;

    public ShapePlacer(Map map) {
        this.map = map;
    }

    public boolean placeShape(List<Coordinate> coordinates, Symbol symbol) {

        Coordinate minCoordinates = calculateMinCoordinates(coordinates);

        List<Coordinate> differenceVectors = getDifferenceVectors(coordinates, minCoordinates.x(), minCoordinates.y());
        if (differenceVectors.isEmpty()) {
            return false;
        }

        Coordinate randomVector = pickRandomElement(differenceVectors);
        List<Coordinate> finalCoordinates = shiftCoordinates(coordinates, randomVector.x(), randomVector.y());
        for (Coordinate coordinate : finalCoordinates) {
            map.setCoordinate(coordinate, symbol);
        }

        return true;
    }

    private Coordinate calculateMinCoordinates(List<Coordinate> coordinates) {
        int minX = map.getWidth();
        int minY = map.getWidth();
        for (Coordinate coordinate : coordinates) {
            if (coordinate.x() < minX) {
                minX = coordinate.x();
            }
            if (coordinate.y() < minY) {
                minY = coordinate.y();
            }
        }

        return new Coordinate(minX, minY);
    }

    private List<Coordinate> getDifferenceVectors(List<Coordinate> coordinates, int minX, int minY) {
        List<Coordinate> differenceVectors = new ArrayList<>();
        for (int i = -minX; i < map.getWidth() - minX; i++) {
            for (int j = -minY; j < map.getWidth() - minY; j++) {
                if (PlacementValidator.validatePlacement(shiftCoordinates(coordinates, i, j), map)) {
                    differenceVectors.add(new Coordinate(i, j));
                }
            }
        }
        return differenceVectors;
    }

    private List<Coordinate> shiftCoordinates(List<Coordinate> coordinates, int diffX, int diffY) {
        return coordinates.stream().map(coordinate -> new Coordinate(coordinate.x() + diffX, coordinate.y() + diffY)).toList();
    }


}
