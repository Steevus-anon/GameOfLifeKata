package com.example.project;

public class Cell extends Neighbor {
    private boolean alive = false;

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

    @Override
    public void informNeighbors() {
        if (alive) {
            for (int i = 0; i < neighborCount; i++) {
                neighborhood[i].beInformedOfLife();
            }
        }
    }

    public String toString() {
        if (alive) return "1";
        return "0";
    }
}
