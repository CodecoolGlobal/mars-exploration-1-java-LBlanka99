package com.codecool.marsexploration.logic.resourceLogic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidSingleCasesTest {

    Map map = new Map(32);
    ValidSingleCases validSingleCases = new ValidSingleCases();


    @Test
    void testWhenThereArentAnyPits() {
        boolean result = validSingleCases.isValidPlacement(new Coordinate(5, 5), map, Symbol.PIT);
        assertFalse(result);
    }

    @Test
    void testValidCase() {
        map.setCoordinate(new Coordinate(5,5), Symbol.PIT);
        boolean result = validSingleCases.isValidPlacement(new Coordinate(4, 5), map, Symbol.PIT);
        assertTrue(result);
    }

    @Test
    void testWhenCoordinatesArentEmpty() {
        map.setCoordinate(new Coordinate(5, 5), Symbol.PIT);
        map.setCoordinate(new Coordinate(4, 5), Symbol.MINERAL);
        boolean result = validSingleCases.isValidPlacement(new Coordinate(4, 5), map, Symbol.PIT);
    }

}