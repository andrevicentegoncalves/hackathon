package com.academiadecodigo.hackathon.world;

import com.academiadecodigo.hackathon.world.interactable.Interactable;

import java.util.HashMap;

public class GridArea {
    Coord[] entryPoints;
    Coord[] exitPoints;
    int[][] topdownMapTiles;
    HashMap<Coord,Interactable> pointOfInterest;

}
