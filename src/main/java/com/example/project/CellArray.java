package com.example.project;

import java.util.Arrays;
import java.util.Iterator;

public class CellArray implements Iterable<Cell> {
    private Cell internalArray[][];
    private int width;
    private int height;

    public CellArray(int width, int height) {
        this.width = width;
        this.height = height;
        internalArray = new Cell[width][height];
        populateArray();
    }

    private void populateArray() {
        for (int x = 0; x < width; x++) {
            populateColumn(x);
        }
    }

    private void populateColumn(int x) {
        for (int y = 0; y < height; y++) {
            internalArray[x][y] = new Cell();
        }
    }

    public void toggleCell(int x, int y) {
        internalArray[x][y].toggle();
    }

    public Cell[][] getInternalArray() {
        return internalArray;
    }

    public String toString() {
        String output = "";

        for (Cell[] column : internalArray) {
            String s = Arrays.toString(column);
            output = output.concat(s + "\n");
        }

        return output;
    }

    @Override
    public Iterator<Cell> iterator() {
        return new CellArrayIterator();
    }

    class CellArrayIterator implements Iterator<Cell> {
        private int x = 0;
        private int y = 0;

        @Override
        public boolean hasNext() {
            return width - x != 1 || height - y != 1;
        }

        @Override
        public Cell next() {
            y++;

            if (y == height) {
                x++;
                y = 0;
            }

            return internalArray[x][y];
        }
    }
}
