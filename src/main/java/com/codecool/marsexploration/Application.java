package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.Configurator;

import java.util.List;
import java.util.Random;
import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.ui.UI;
import com.codecool.marsexploration.util.FileWriter;

import java.io.*;

public class Application {
    public static final String FILE_PATH = "src/main/resources/";
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run(FILE_PATH);
    }
}
