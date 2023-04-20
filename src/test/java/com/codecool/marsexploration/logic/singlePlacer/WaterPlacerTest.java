package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterPlacerTest {

    Map map = new Map(32);
    WaterPlacer waterPlacer = new WaterPlacer(20, map);


    @Test
    void testWhenThereArentAnyPits() {
        boolean result = waterPlacer.isValidPlacement(new Coordinate(5, 5), map, Symbol.PIT);
        assertFalse(result);
    }

    @Test
    void testValidCase() {
        map.setCoordinate(new Coordinate(5,5), Symbol.PIT);
        boolean result = waterPlacer.isValidPlacement(new Coordinate(4, 5), map, Symbol.PIT);
        assertTrue(result);
    }

    @Test
    void testWhenCoordinatesArentEmpty() {
        map.setCoordinate(new Coordinate(5, 5), Symbol.PIT);
        map.setCoordinate(new Coordinate(4, 5), Symbol.MINERAL);
        boolean result = waterPlacer.isValidPlacement(new Coordinate(4, 5), map, Symbol.PIT);
        assertFalse(result);
    }

}