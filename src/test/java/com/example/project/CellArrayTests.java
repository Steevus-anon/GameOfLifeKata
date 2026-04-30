package com.example.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CellArrayTests {
    @Test
    void initializeCellArrayTest() {
        CellArray cells = new CellArray(5, 5);
        Neighbor internalArray[][] = cells.getInternalArray();
        assertEquals(5, internalArray.length);
    }

    @Test
    void toggleCellInArray() {
        CellArray cells = new CellArray(3, 3);
        cells.toggleCell(0, 0);
        String s = cells.toString();
        assertEquals("[1, 0, 0]\n[0, 0, 0]\n[0, 0, 0]\n", s);
    }

    @Test
    void squareTest() {
        CellArray cells = new CellArray(2, 2);
        cells.toggleMultiple(
            0, 0,
            0, 1,
            1, 0,
            1, 1
        );
        cells.iterate();
        assertEquals("[1, 1]\n[1, 1]\n", cells.toString());
    }
}
