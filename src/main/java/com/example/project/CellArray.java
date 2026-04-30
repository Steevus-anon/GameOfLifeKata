package com.example.project;

import java.util.Arrays;

public class CellArray {
    private Cell externalArray[][];
    private int width;
    private int height;

    private Neighbor internalArray[][];
    private int internalWidth;
    private int internalHeight;

    public CellArray(int width, int height) {
        this.width = width;
        this.height = height;
        initializeArrays();
        populateArrays();
    }

    private void initializeArrays() {
        internalWidth = width + 2;
        internalHeight = height + 2;
        externalArray = new Cell[width][height];
        internalArray = new Neighbor[internalWidth][internalHeight];
    }

    private void populateArrays() {
        for (int x = 0; x < internalWidth; x++) {
            populateColumn(x);
        }
    }

    private void populateColumn(int x) {
        for (int y = 0; y < internalHeight; y++) {
            populateElement(x, y);
        }
    }

    private void populateElement(int x, int y) {
        if (x == 0 || y == 0 ||
            x > width || y > height) {
            internalArray[x][y] = new Neighbor();
        } else {
            Cell c = new Cell();
            externalArray[x - 1][y - 1] = c;
            internalArray[x][y] = c;
        }
    }

    public void toggleCell(int x, int y) {
        externalArray[x][y].toggle();
    }

    public Neighbor[][] getInternalArray() {
        return internalArray;
    }

    public String toString() {
        String output = "";

        for (Cell[] column : externalArray) {
            String s = Arrays.toString(column);
            output = output.concat(s + "\n");
        }

        return output;
    }
}
