package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.resourceLogic.MineralPlacer;
import com.codecool.marsexploration.logic.resourceLogic.WaterPlacer;

import java.util.List;

public class Configurator {

    private static final int MAX_TRIES = 10;
    ShapeGenerator shapeGenerator;
    private final int width;

    public Configurator(int width) {
        this.width = width;
        shapeGenerator = new ShapeGenerator();

    }

    public Map drawMap(List<Integer> mountainSizes, List<Integer> pitSizes, int waterAmount, int mineralAmount) {
        Map map = new Map(width);
        ShapePlacer shapePlacer = new ShapePlacer(map);
        WaterPlacer waterPlacer = new WaterPlacer(waterAmount, map);
        MineralPlacer mineralPlacer = new MineralPlacer(mineralAmount, map);

        place2D(mountainSizes, Symbol.MOUNTAIN, shapePlacer);
        place2D(pitSizes, Symbol.PIT, shapePlacer);
        mineralPlacer.placeSymbolsRandomlyToThePossiblePlaces();
        waterPlacer.placeSymbolsRandomlyToThePossiblePlaces();
        return map;
    }

    private void place2D(List<Integer> sizes, Symbol symbol, ShapePlacer shapePlacer) {
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
