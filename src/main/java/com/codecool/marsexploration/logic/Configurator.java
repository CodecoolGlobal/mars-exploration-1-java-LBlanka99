package com.codecool.marsexploration.logic;

import java.util.List;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.singlePlacer.SinglePlacer;

public class Configurator {


    private int width;
    Map map;
    ShapeGenerator shapeGenerator;
    ShapePlacer shapePlacer;
    private static final int MAX_TRIES = 10;

    public Configurator(int width) {
        this.width = width;
        map = new Map(width);
        shapeGenerator = new ShapeGenerator();
        shapePlacer = new ShapePlacer(map);
    }

    public Map drawMap(List<Integer> mountainSizes, List<Integer> pitSizes, int waterAmount, int mineralAmount) {
        SinglePlacer singlePlacer = new SinglePlacer();
        place2D(mountainSizes, Symbol.MOUNTAIN);
        place2D(pitSizes, Symbol.PIT);
        singlePlacer.placeSymbolsRandomly(Symbol.MINERAL, mineralAmount, map);
        singlePlacer.placeSymbolsRandomly(Symbol.WATER, waterAmount, map);
        return map;
    }

    private void place2D(List<Integer> sizes, Symbol symbol) {
        for (Integer size : sizes) {
            int tries = 0;
            boolean succesfulPlacement = false;
            while (tries < MAX_TRIES && !succesfulPlacement) {
                List<Coordinate> coordinates = shapeGenerator.generateShape(size);
                succesfulPlacement = shapePlacer.placeShape(coordinates, symbol);
                tries++;
            }
        }
    }
}
