package com.codecool.marsexploration.ui;

import com.codecool.marsexploration.data.Map;
import com.codecool.marsexploration.logic.Configurator;
import com.codecool.marsexploration.util.FileWriter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private static final int MAP_WIDTH = 32;

    public UI (){
        scanner = new Scanner(System.in);
    }

    public void run(String FILE_PATH) {
        FileWriter fileWriter = new FileWriter();
        Configurator configurator = new Configurator(MAP_WIDTH);

        System.out.println("Hello! Welcome to Mars exploration!");
        int mountainRangeAmount = getIntInput("How many mountain ranges do you want to place?");
        List<Integer> mountainSizes = new ArrayList<>();
        for(int i = 1; i <= mountainRangeAmount; i++){
            mountainSizes.add(getIntInput("Give me the area of mountain range number "+i));
        }

        int pitsAmount = getIntInput("How many pits do you want to place?");
        List<Integer> pitSizes = new ArrayList<>();
        for(int i = 1; i <= pitsAmount; i++){
            pitSizes.add(getIntInput("Give me the area of pit number "+i));
        }

        int waterAmount = getIntInput("How many waters do you want to place?");
        int mineralAmount = getIntInput("How many minerals do you want to place?");

        System.out.println("What would be the file name?");
        String filename = scanner.next();

        Map map = configurator.drawMap(mountainSizes, pitSizes, waterAmount, mineralAmount);
        fileWriter.Writer(map, FILE_PATH, filename);
    }

    private int getIntInput(String message) {
        boolean isValidInput = false;
        int number = 0;

        while(!isValidInput) {
            System.out.println(message);
            try {
                number = Integer.valueOf(scanner.nextLine());
                isValidInput = true;
            } catch(NumberFormatException e) {
                System.out.println("This is an invalid input. You should give me an integer!");
            }
        }

        return number;
    }
}
