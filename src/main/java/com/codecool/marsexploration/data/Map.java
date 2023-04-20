package com.codecool.marsexploration.data;

public class Map {
    private final char[][] map;

    private final int width;

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

    public void setCoordinate(Coordinate coordinate, Symbol symbol) {
        if (coordinate.x() < 0 || coordinate.y() < 0 || coordinate.x() >= width || coordinate.y() >= width) {
            System.out.println("You wanted to set coordinates out of the map!");
            return;
        }
        if (map[coordinate.x()][coordinate.y()] == ' ') {
            map[coordinate.x()][coordinate.y()] = symbol.getSymbol();
        }
    }

    private void fillEmptySpace() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = ' ';
            }
        }
    }
}
