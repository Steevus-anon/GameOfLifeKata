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
    private Cell[][] array;

    public CellArrayConstructor(int width, int height) {
        this.width = width;
        this.height = height;
        array = new Cell[width][height];
        populateArray();
        linkCells();
    }

    private void populateArray() {
        for (int x = 0; x < width; x++) {
            populateColumn(x);
        }
    }

    private void populateColumn(int x) {
        for (int y = 0; y < height; y++) {
            array[x][y] = new Cell();
        }
    }

    private void linkCells() {
        for (int x = 0; x < width; x++) {
            linkCellsInColumn(x);
        }
    }

    private void linkCellsInColumn(int x) {
        for (int y = 0; y < height; y++) {
            linkIndividualCell(x, y);
        }
    }

    private void linkIndividualCell(int x, int y) {
        Cell c = array[x][y];

        for (int[] pos : POSSIBLE_NEIGHBORS) {
            addNeighborIfValid(c, x + pos[0], y + pos[1]);
        }
    }

    private void addNeighborIfValid(Cell c, int x, int y) {
        if (!isValidPosition(x, y)) return;
        c.addNeighbor(array[x][y]);
    }

    private boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= width || y >= height) return false;
        return true;
    }

    public Cell[][] getArray() {
        return array;
    }
}
