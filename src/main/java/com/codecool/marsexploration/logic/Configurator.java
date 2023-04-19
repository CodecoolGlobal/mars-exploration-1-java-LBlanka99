package com.codecool.marsexploration.logic;

import java.util.List;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.singlePlacer.SinglePlacer;

public class Configurator {


    private int width;
    private String filename;
    Map map;
    ShapeGenerator shapeGenerator;
    ShapePlacer shapePlacer;
    private static final int MAX_TRIES = 10;

    public Configurator(int width, String filename) {
        this.width = width;
        this.filename = filename;
        map = new Map(width);
        shapeGenerator = new ShapeGenerator();
        shapePlacer = new ShapePlacer(map);
    }

    public Map drawMap(List<Integer> mountainSizes, List<Integer> pitSizes, int waterAmount, int mineralAmount) {
        SinglePlacer waterPlacer = new SinglePlacer(Symbol.WATER, waterAmount, map);
        SinglePlacer mineralPlacer = new SinglePlacer(Symbol.MINERAL, mineralAmount, map);
        place2D(mountainSizes, Symbol.MOUNTAIN);
        place2D(pitSizes, Symbol.PIT);
        waterPlacer.placeSymbolsRandomly();
        mineralPlacer.placeSymbolsRandomly();
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
