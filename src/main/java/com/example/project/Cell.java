package com.example.project;

public class Cell extends Neighbor {
    private boolean alive;

    public boolean isLiving() {
        return alive;
    }

    public void birth() {
        alive = true;
    }

    public void kill() {
        alive = false;
    }

    public void toggle() {
        alive = !alive;
    }
}
