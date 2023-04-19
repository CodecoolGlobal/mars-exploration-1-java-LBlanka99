package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.Configurator;

import java.util.List;
import java.util.Random;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.util.FileWriter;

import java.io.*;

public class Application {
    public static final String FILE_PATH = "src/main/resources/";
    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriter();
        Configurator configurator = new Configurator(35);

        Map map = configurator.drawMap(List.of(10, 20, 30), List.of(5, 15), 8, 12);
        fileWriter.Writer(map, FILE_PATH, "create-map");

    }
}
