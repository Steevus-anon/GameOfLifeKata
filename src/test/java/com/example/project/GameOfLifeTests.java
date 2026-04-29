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
}
