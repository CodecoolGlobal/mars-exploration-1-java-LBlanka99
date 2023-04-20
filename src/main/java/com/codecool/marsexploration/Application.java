package com.codecool.marsexploration;

import com.codecool.marsexploration.ui.UI;

public class Application {
    public static final String FILE_PATH = "src/main/resources/";

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run(FILE_PATH);
    }
}
