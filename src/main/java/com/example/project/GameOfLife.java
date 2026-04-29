package com.example.project;

public class GameOfLife {
    public static int CELL_COLUMNS = 50;
    public static int CELL_ROWS = 50;

    public GameOfLife() {
        new Display();
    }

    public static void main(String[] args) {
        new GameOfLife();
    }
}
