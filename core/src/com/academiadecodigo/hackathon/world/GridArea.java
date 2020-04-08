package com.academiadecodigo.hackathon.world;

import com.academiadecodigo.hackathon.world.interactable.Interactable;

import java.util.HashMap;

public class GridArea {
    Coord[] entryPoints;
    Coord[] exitPoints;
    int[][] topdownMapTiles;
    HashMap<Coord,Interactable> pointOfInterest;

    int width;
    int height;





    public Coord[] getEntryPoints() {
        return entryPoints;
    }

    public void setEntryPoints(Coord[] entryPoints) {
        this.entryPoints = entryPoints;
    }

    public Coord[] getExitPoints() {
        return exitPoints;
    }

    public void setExitPoints(Coord[] exitPoints) {
        this.exitPoints = exitPoints;
    }

    public int[][] getTopdownMapTiles() {
        return topdownMapTiles;
    }

    public void setTopdownMapTiles(int[][] topdownMapTiles) {
        this.topdownMapTiles = topdownMapTiles;
    }

    public HashMap<Coord, Interactable> getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(HashMap<Coord, Interactable> pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isInside(Coord coord) {
        return  (0 <= coord.getX() && coord.getX() < getWidth() &&
            0 <= coord.getY() && coord.getY() < getHeight());
    }

    //TODO: edge of the worlds and tile types into consideration
    public boolean isEdge(Coord coord, Direction dir) {
        /*switch (dir) {
            case UP:
                if ()
                return true;
            case DOWN:
                if ()
                return true;
            case LEFT:
                if ()
                return true;
            case RIGHT:
                if ()
                return true;
            default:
                return false;
        }*/
        return false;
    }

}
