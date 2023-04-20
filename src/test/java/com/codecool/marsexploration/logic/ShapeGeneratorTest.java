package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ShapeGeneratorTest {
  ShapeGenerator shapeGenerator = new ShapeGenerator();

  @Test
    public void testGenerator(){
      int amount = 10;
     List<Coordinate> shapeCoordinates =  shapeGenerator.generateShape(amount);
     assertEquals(shapeCoordinates.size(), amount);

  }
}