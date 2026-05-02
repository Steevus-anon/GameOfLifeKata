package com.example.project;

public class CellArrayConstructor {
    private static int[][] POSSIBLE_NEIGHBORS = {
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1}
    };

    private int width;
    private int height;
    private Cell[][] output;

    public CellArrayConstructor(int width, int height) {
        this.width = width;
        this.height = height;
        output = new Cell[width][height];
        populateArray();
        addNeighbors();
    }

    private void populateArray() {
        for (int x = 0; x < width; x++) {
            populateColumn(x);
        }
    }

    private void populateColumn(int x) {
        for (int y = 0; y < height; y++) {
            output[x][y] = new Cell();
        }
    }

    private void addNeighbors() {
        for (int x = 0; x < width; x++) {
            addNeighborsForColumn(x);
        }
    }

    private void addNeighborsForColumn(int x) {
        for (int y = 0; y < height; y++) {
            addNeighborsForIndividual(x, y);
        }
    }

    private void addNeighborsForIndividual(int x, int y) {
        Cell c = output[x][y];

        for (int[] pos : POSSIBLE_NEIGHBORS) {
            addNeighborIfValid(c, x + pos[0], y + pos[1]);
        }
    }

    private void addNeighborIfValid(Cell c, int x, int y) {
        if (!isValidPosition(x, y)) return;
        c.addNeighbor(output[x][y]);
    }

    private boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= width || y >= height) return false;
        return true;
    }

    public Cell[][] getArray() {
        return output;
    }
}
