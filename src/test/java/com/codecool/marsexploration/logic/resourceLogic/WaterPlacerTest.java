package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterPlacerTest {
    Map map = new Map(3);
    WaterPlacer waterPlacer = new WaterPlacer(1, map);

    @Test
    void testWithEmptyMap() {
        waterPlacer.placeSymbolsRandomlyToThePossiblePlaces();
        char[][] expected = new char[3][3];
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                expected[i][j] = ' ';
            }
        }
        assertArrayEquals(map.getMap(), expected);
    }

    @Test
    void testWhenHaveMountains() {
        map.setCoordinate(new Coordinate(0, 0), Symbol.PIT);
        map.setCoordinate(new Coordinate(0, 1), Symbol.MOUNTAIN);
        map.setCoordinate(new Coordinate(1, 0), Symbol.MOUNTAIN);
        waterPlacer.placeSymbolsRandomlyToThePossiblePlaces();

        assertEquals(map.getMap()[1][1], Symbol.WATER.getSymbol());

    }
}