package com.example.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CellArrayTests {
    @Test
    void initializeCellArrayTest() {
        CellArray myCellArray = new CellArray(5, 5);
        Neighbor internalArray[][] = myCellArray.getInternalArray();
        assertEquals(5, internalArray.length);
    }

    @Test
    void toggleCellInArray() {
        CellArray myCellArray = new CellArray(3, 3);
        myCellArray.toggleCell(0, 0);
        String s = myCellArray.toString();
        assertEquals("[1, 0, 0]\n[0, 0, 0]\n[0, 0, 0]\n", s);
    }
}
