package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ShapeGeneratorTest {
  ShapeGenerator shapeGenerator = new ShapeGenerator();

  @Test
    public void testGenerator(){
     List<Coordinate> stuff =  shapeGenerator.generateShape(10);
     for(Coordinate what : stuff){
         System.out.println(what);
     }
  }
}