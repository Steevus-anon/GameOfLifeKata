package com.example.project;

public class Neighbor {
    protected Neighbor neighborhood[] = new Neighbor[4];
    protected int neighborCount = 0;
    protected int livingNeighbors = 0;

    public void addNeighbor(Neighbor n) {
        neighborhood[neighborCount] = n;
        neighborCount++;
    }

    public void beInformedOfLife() {
        livingNeighbors++;
    }

    public void informNeighbors() {}

    public int getLiveNeighborCount() {
        return livingNeighbors;
    }

    public void resetLivingNeighbors() {
        livingNeighbors = 0;
    }
}
