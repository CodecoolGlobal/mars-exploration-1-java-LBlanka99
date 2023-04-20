package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineralPlacerTest {

    Map map = new Map(32);
    MineralPlacer mineralPlacer = new MineralPlacer(5, map);


    @Test
    void testWhenThereArentAnyMountains() {
        boolean result = mineralPlacer.isValidPlacement(new Coordinate(5, 5), map, Symbol.MOUNTAIN);
        assertFalse(result);
    }

    @Test
    void testValidCase() {
        map.setCoordinate(new Coordinate(5,5), Symbol.MOUNTAIN);
        boolean result = mineralPlacer.isValidPlacement(new Coordinate(4, 5), map, Symbol.MOUNTAIN);
        assertTrue(result);
    }

    @Test
    void testWhenCoordinatesArentEmpty() {
        map.setCoordinate(new Coordinate(5, 5), Symbol.MOUNTAIN);
        map.setCoordinate(new Coordinate(4, 5), Symbol.WATER);
        boolean result = mineralPlacer.isValidPlacement(new Coordinate(4, 5), map, Symbol.MOUNTAIN);
        assertFalse(result);
    }

}