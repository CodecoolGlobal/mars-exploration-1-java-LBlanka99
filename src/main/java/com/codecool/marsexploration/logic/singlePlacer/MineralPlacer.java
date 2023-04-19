package com.codecool.marsexploration.logic.singlePlacer;

import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.data.Symbol;

public class MineralPlacer extends SinglePlacer{
    public MineralPlacer(int amount, Map map) {
        super(amount, map);
        this.toPlace = Symbol.MINERAL;
        this.placeNear = Symbol.MOUNTAIN;
    }
}
