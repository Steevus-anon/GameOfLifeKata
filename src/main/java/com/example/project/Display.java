package com.example.project;

import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {
    public static int CELL_SIZE = 16;
    public static int BUTTON_HEIGHT = 200;

    private int width;
    private int height;
    private CellDisplay cells;

    public Display() {
        super("Conway's Game of Life");
        initializeWindow();
        setLayout(new BorderLayout());
        addComponents();
    }

    private void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        determineSize();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void determineSize() {
        width = CELL_SIZE * GameOfLife.CELL_COLUMNS;
        height = CELL_SIZE * GameOfLife.CELL_ROWS + BUTTON_HEIGHT;
        setSize(width, height);
    }

    public void addComponents() {
        cells = new CellDisplay(width, height - BUTTON_HEIGHT);
        add(cells);
    }
}
