package com.example.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements KeyListener {
    public static int CELL_COLUMNS = 50;
    public static int CELL_ROWS = 50;
    public static int CELL_SIZE = 16;
    public static int BUTTON_HEIGHT = 200;

    private int width;
    private int height;
    private CellDisplay cells;

    public GameOfLife() {
        super("Conway's Game of Life");
        initializeWindow();
        setLayout(new BorderLayout());
        addComponents();
        addListeners();
    }

    private void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        determineSize();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void determineSize() {
        width = CELL_SIZE * CELL_COLUMNS;
        height = CELL_SIZE * CELL_ROWS + BUTTON_HEIGHT;
        setSize(width, height);
    }

    public void addComponents() {
        cells = new CellDisplay(width, height - BUTTON_HEIGHT);
        add(cells);
    }

    public void addListeners() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int val = e.getKeyChar();

        if (val == 27) { // esc
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new GameOfLife();
    }
}
