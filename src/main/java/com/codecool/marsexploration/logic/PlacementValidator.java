package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;

import java.util.List;


public class PlacementValidator {
    public static boolean validatePlacement(List<Coordinate> coordinates, Map map) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.x() < 0 || coordinate.y() < 0 || coordinate.x() >= map.getWidth() || coordinate.y() >= map.getWidth()) {
                return false;
            }
            if (map.getMap()[coordinate.x()][coordinate.y()] != ' ') {
                return false;
            }
        }
        return true;
    }
}
