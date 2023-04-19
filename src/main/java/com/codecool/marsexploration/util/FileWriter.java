package com.codecool.marsexploration.util;

import java.io.BufferedWriter;
import java.io.IOException;
import com.codecool.marsexploration.data.Map;


public class FileWriter {

    public void Writer (Map map, String filePath, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath + fileName + ".map"))) {
            writer.write(buildString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildString(Map map) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                content.append(map.getMap()[i][j]);
            }
            content.append("\n");
        }
        return content.toString();
    }
}
