package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.Configurator;

import java.util.List;
import java.util.Random;
import com.codecool.marsexploration.data.Map;
import java.io.*;

public class Application {
    private static final String FILE_PATH = "src/main/resources/";
    public static void main(String[] args) {


        Configurator configurator = new Configurator(35);
        Map map = configurator.drawMap(List.of(10, 20, 30), List.of(5, 15), 8, 12);

        StringBuilder content = new StringBuilder();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                content.append(map.getMap()[i][j]);
            }
            content.append("\n");
        }
        String contentString = content.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + "test-1.map"))) {
            writer.write(contentString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
