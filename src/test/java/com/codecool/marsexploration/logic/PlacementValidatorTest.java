package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlacementValidatorTest {

    PlacementValidator validator = new PlacementValidator();
    Map map = new Map(32);

    @Test
    void testValidCase(){
        boolean result = PlacementValidator.validatePlacement(List.of(new Coordinate(5,5), new Coordinate(10, 10), new Coordinate(3,3)), map);
        assertTrue(result);
    }

    @Test
    void testWhenCoordinatesAreOutOfMap() {
        boolean result = PlacementValidator.validatePlacement(List.of(new Coordinate(0,1), new Coordinate(30, 10), new Coordinate(5,42)), map);
        assertFalse(result);
    }

    @Test
    void testWhenCoordinatesArentEmpty() {
        map.setCoordinate(new Coordinate(6, 7), Symbol.PIT);
        boolean result = PlacementValidator.validatePlacement(List.of(new Coordinate(5,5), new Coordinate(6, 7), new Coordinate(10, 10)), map);
        assertFalse(result);
    }
}