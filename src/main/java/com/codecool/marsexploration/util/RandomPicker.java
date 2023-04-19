package com.codecool.marsexploration.util;

import java.util.List;
import java.util.Random;

public class RandomPicker {

    public static <T> T pickRandomElement(List<T> items){
        Random random = new Random();
        int randomIndex = random.nextInt(items.size());
        return items.get(randomIndex);
    }
}
