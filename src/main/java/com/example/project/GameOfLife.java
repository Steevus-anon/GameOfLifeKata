package com.example.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements KeyListener, MouseListener {
    public static int CELL_COLUMNS = 50;
    public static int CELL_ROWS = 50;
    public static int CELL_SIZE = 16;

    private int width;
    private int height;
    private CellDisplay display;
    private CellArray cells;

    public GameOfLife() {
        super("Conway's Game of Life");
        intializeGame();
        initializeWindow();
        setLayout(new BorderLayout());
        addComponents();
        addListeners();
    }

    private void intializeGame() {
        cells = new CellArray(CELL_COLUMNS, CELL_ROWS);
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
        height = CELL_SIZE * CELL_ROWS;
        setSize(width, height);
    }

    public void addComponents() {
        display = new CellDisplay(cells, width, height);
        add(display);
    }

    public void addListeners() {
        addKeyListener(this);
        display.addMouseListener(this);
    }

    private void update() {
        repaint();
        revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int val = e.getKeyChar();

        if (val == 27) { // esc
            System.exit(0);
        } else if (val == 32) { // space
            cells.iterate();
        } else if (val == 114) { // r
            cells.reset();
        }

        update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / CELL_SIZE;
        int y = e.getY() / CELL_SIZE;
            
        if (isPositionValid(x, y)) {
            cells.toggleCell(x, y);
            update();
        }
    }

    private boolean isPositionValid(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= CELL_COLUMNS || y >= CELL_ROWS) return false;
        return true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new GameOfLife();
    }
}
