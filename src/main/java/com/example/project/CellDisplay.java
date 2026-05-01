package com.example.project;

import java.awt.*;
import javax.swing.*;

public class CellDisplay extends JPanel {
    private CellArray cells;
    private int width;
    private int height;
    private int cursorX;
    private int cursorY;

    public CellDisplay(CellArray cells, int width, int height) {
        super();
        this.cells = cells;
        this.width = width;
        this.height = height;
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        paintBackground(g);
        g.setColor(Color.WHITE);
        cursorX = 0;
        cursorY = 0;

        for (Cell c : cells) {
            if (c.isLiving()) {
                g.fillRect(cursorX, cursorY, GameOfLife.CELL_SIZE, GameOfLife.CELL_SIZE);
            }
            iterateCursor();
        }
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }

    private void iterateCursor() {
        cursorY += GameOfLife.CELL_SIZE;
        if (cursorY == height) {
            cursorX += GameOfLife.CELL_SIZE;
            cursorY = 0;
        }
    }
}
