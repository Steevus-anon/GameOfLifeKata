package com.example.project;

import java.awt.*;
import javax.swing.*;

public class CellDisplay extends JPanel {
    public CellDisplay(int width, int height) {
        super();
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0, GameOfLife.CELL_SIZE, GameOfLife.CELL_SIZE);
    }
}
