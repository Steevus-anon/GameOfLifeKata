package com.example.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements KeyListener, MouseListener {
    public static int CELL_COLUMNS = 50;
    public static int CELL_ROWS = 50;
    public static int CELL_SIZE = 16;
    public static int BUTTON_HEIGHT = 200;

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
        height = CELL_SIZE * CELL_ROWS + BUTTON_HEIGHT;
        setSize(width, height);
    }

    public void addComponents() {
        display = new CellDisplay(cells, width, height - BUTTON_HEIGHT);
        add(display);
    }

    public void addListeners() {
        addKeyListener(this);
        addMouseListener(this);
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
            update();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int screenX = e.getX(),
            x = screenX / CELL_SIZE;
        int screenY = e.getY(),
            y = screenY / CELL_SIZE;
        if (!areCoordsOnScreen(screenX, screenY)) return;
        cells.toggleCell(x, y);
        update();
    }

    private boolean areCoordsOnScreen(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= width || y >= display.getHeight()) return false;
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
