package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineralPlacerTest {

    Map map = new Map(3);
    MineralPlacer mineralPlacer = new MineralPlacer(1, map);

    @Test
    void testWhenThereArentAnyPits() {
        mineralPlacer.placeSymbolsRandomlyToThePossiblePlaces();
        char[][] expected = new char[3][3];
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; )
        }

    }


}