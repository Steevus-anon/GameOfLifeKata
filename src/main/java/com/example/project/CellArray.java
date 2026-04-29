package com.example.project;

public class CellArray {
    private int width;
    private int height;

    private Neighbor internalArray[][];
    private int internalWidth;
    private int internalHeight;

    public CellArray(int width, int height) {
        this.width = width;
        this.height = height;
        intializeInternalArray();
        populateInternalArray();
    }

    private void intializeInternalArray() {
        internalWidth = width + 2;
        internalHeight = height + 2;
        internalArray = new Neighbor[internalWidth][internalHeight];
    }

    private void populateInternalArray() {
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
            internalArray[x][y] = new Cell();
        }
    }

    public Neighbor[][] getInternalArray() {
        return internalArray;
    }
}
