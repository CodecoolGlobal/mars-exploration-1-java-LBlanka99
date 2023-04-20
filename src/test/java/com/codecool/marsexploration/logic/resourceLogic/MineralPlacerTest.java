package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MineralPlacerTest {

    Map map = new Map(3);
    MineralPlacer mineralPlacer = new MineralPlacer(1, map);

    @Test
    void testWithEmptyMap(){
        mineralPlacer.placeSymbolsRandomlyToThePossiblePlaces();
        char[][] expected = new char[3][3];
        for (int i = 0; i < expected.length; i++) {
            for(int j = 0; j < expected.length; j++){
                expected[i][j] = ' ';
            }
        }
        assertArrayEquals(map.getMap(), expected);
    }

    @Test
    void testWhenHaveMountains(){
        map.setCoordinate(new Coordinate(0,0), Symbol.MOUNTAIN);
        map.setCoordinate(new Coordinate(0, 1), Symbol.PIT);
        map.setCoordinate(new Coordinate(1, 0), Symbol.PIT);
        mineralPlacer.placeSymbolsRandomlyToThePossiblePlaces();

        assertTrue(map.getMap()[1][1] == Symbol.MINERAL.getSymbol());

    }

}