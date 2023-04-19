package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;

public class WaterPlacer extends SinglePlacer{
    public WaterPlacer(int amount, Map map) {
        super(amount, map);
        this.toPlace = Symbol.WATER;
        this.placeNear = Symbol.PIT;
    }
}
