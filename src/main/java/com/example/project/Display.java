package com.example.project;

import javax.swing.*;

public class Display extends JFrame {
    public static int CELL_SIZE = 16;
    public static int BUTTON_HEIGHT = 200;

    public Display() {
        super("Conway's Game of Life");
        initializeWindow();
    }

    private void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        determineSize();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void determineSize() {
        int width = CELL_SIZE * GameOfLife.CELL_COLUMNS;
        int height = CELL_SIZE * GameOfLife.CELL_ROWS + BUTTON_HEIGHT;
        setSize(width, height);
    }
}
