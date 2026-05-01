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
        CellArrayConstructor constr = new CellArrayConstructor(width, height);
        internalArray = constr.getArray();
    }

    public void toggleCell(int x, int y) {
        internalArray[x][y].toggle();
    }

    public void toggleMultiple(int ... args) {
        for (int i = 0; i < args.length; i += 2) {
            int x = args[i];
            int y = args[i + 1];
            toggleCell(x, y);
        }
    }

    public void iterate() {
        informAllCells();
        iterateAllCells();
    }

    private void informAllCells() {
        for (Cell c : this) {
            c.informNeighbors();
        }
    }

    private void iterateAllCells() {
        for (Cell c : this) {
            c.iterate();
        }
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
        private int y = -1;

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
