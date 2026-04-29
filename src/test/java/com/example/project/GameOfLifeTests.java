package com.example.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GameOfLifeTests {
    @Test
    void initializeWindowTest() {
        GameOfLife g = new GameOfLife();
    }

    @Test
    void neighborAndCellExists() {
        Neighbor n = new Neighbor();
        Cell c = new Cell();
    }
}
