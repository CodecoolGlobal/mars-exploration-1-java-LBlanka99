package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import org.junit.jupiter.api.Test;

import java.util.List;
import com.codecool.marsexploration.data.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShapePlacerTest {
    ShapeGenerator shapeGenerator = new ShapeGenerator();
    Map map = new Map(35);
    ShapePlacer shapePlacer = new ShapePlacer(map);

    @Test
    public void testPlacer(){
        List<Coordinate> stuff =  shapeGenerator.generateShape(150);
        shapePlacer.placeShape(stuff, Symbol.MOUNTAIN);
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                System.out.print(map.getMap()[i][j]);
            }
            System.out.println();
        }
    }

}