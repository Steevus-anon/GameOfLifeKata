package com.example.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GameOfLifeTests {
    @Test
    void initializeWindowTest() {
        new GameOfLife();
    }

    @Test
    void neighborAndCellExists() {
        new Neighbor();
        new Cell();
    }

    @Test
    void addNeighborsTest() {
        Neighbor n1 = new Neighbor();
        Neighbor n2 = new Neighbor();
        n1.addNeighbor(n2);
    }

    @Test
    void cellLivingTest() {
        Cell c = new Cell();
        c.birth();
        assert(c.isLiving());
        c.kill();
        assert(!c.isLiving());
        c.toggle();
        assert(c.isLiving());
    }

    @Test
    void informNeighborsTest() {
        Neighbor n = new Neighbor();
        Cell c = new Cell();
        c.birth();
        n.addNeighbor(c);
        c.addNeighbor(n);
        n.informNeighbors();
        c.informNeighbors();
        assertEquals(1, n.getLiveNeighborCount());
        assertEquals(0, c.getLiveNeighborCount());
    }

    @Test
    void initializeCellArrayTest() {
        CellArray myCellArray = new CellArray(5, 5);
        Neighbor internalArray[][] = myCellArray.getInternalArray();
        assertEquals(7, internalArray.length);
    }

    @Test
    void toggleCellInArray() {
        CellArray myCellArray = new CellArray(3, 3);
        myCellArray.toggleCell(0, 0);
        String s = myCellArray.toString();
        assertEquals("[1, 0, 0]\n[0, 0, 0]\n[0, 0, 0]\n", s);
    }
}
