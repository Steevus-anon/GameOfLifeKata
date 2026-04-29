package com.example.project;

public class Neighbor {
    private Neighbor neighborhood[] = new Neighbor[4];
    private int neighborCount = 0;

    public void addNeighbor(Neighbor n) {
        neighborhood[neighborCount] = n;
        neighborCount++;
    }
}
