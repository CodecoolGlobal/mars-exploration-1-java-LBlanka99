package com.codecool.marsexploration.data;

public class Map {
    private char[][] map;

    private int width;

    public Map(int width) {
        this.map = new char[width][width];
        this.width = width;
        fillEmptySpace();
    }

    public int getWidth() {
        return width;
    }
    public char[][] getMap() {
        return map;
    }

    public void setCoordinate(Coordinate coordinate, Symbol symbol){
        if(coordinate.x() >= width || coordinate.y() >= width){
            System.out.println("Not quite good mate");
            return;
        }
        if(map[coordinate.x()][coordinate.y()] == ' '){
            map[coordinate.x()][coordinate.y()] = symbol.getSymbol();
        }
    }

    private void fillEmptySpace(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                map[i][j] = ' ';
            }
        }
    }
}
