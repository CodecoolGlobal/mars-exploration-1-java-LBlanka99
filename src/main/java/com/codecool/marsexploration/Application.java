package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.Configurator;

import java.util.List;
import java.util.Random;
import com.codecool.marsexploration.data.Map;

public class Application {
    public static void main(String[] args) {

        Configurator configurator = new Configurator(35, "nev");
        Map map = configurator.drawMap(List.of(10, 20, 30), List.of(5, 15), 8, 12);

        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                System.out.print(map.getMap()[i][j]);
            }
            System.out.println();
        }
    }
}
