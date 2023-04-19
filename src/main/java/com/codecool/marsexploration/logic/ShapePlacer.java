package com.codecool.marsexploration.logic;


import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import static com.codecool.marsexploration.util.RandomPicker.pickRandomElement;

import java.util.ArrayList;
import java.util.List;

public class ShapePlacer {
    private Map map;

    public ShapePlacer(Map map) {
        this.map = map;
    }

    public boolean placeShape(List<Coordinate> coordinates, Symbol symbol) {
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

        List<Coordinate> differenceVectors = new ArrayList<>();

        for (int i = -minX; i < map.getWidth() - minX; i++) {
            for (int j = -minY; j < map.getWidth() - minY; j++) {
                if (PlacementValidator.validatePlacement(shiftCoordinates(coordinates, i, j),map)) {
                    differenceVectors.add(new Coordinate(i,j));
                }
            }
        }

        if (differenceVectors.isEmpty()) {
            return false;
        }

        Coordinate randomVector = pickRandomElement(differenceVectors);
        List<Coordinate> finalCoordinates = shiftCoordinates(coordinates, randomVector.x(), randomVector.y());

        for (Coordinate coordinate: finalCoordinates) {
            map.setCoordinate(coordinate, symbol);
        }

        return true;
    }

    private List<Coordinate> shiftCoordinates(List<Coordinate> coordinates, int diffX, int diffY) {
        return coordinates.stream().map(coordinate -> new Coordinate(coordinate.x() + diffX, coordinate.y() + diffY)).toList();
    }


}
