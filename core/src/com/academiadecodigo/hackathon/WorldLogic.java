package com.academiadecodigo.hackathon;

import com.academiadecodigo.hackathon.world.Coord;
import com.academiadecodigo.hackathon.world.Direction;
import com.academiadecodigo.hackathon.world.GridArea;

public class WorldLogic {

    private GridArea gridArea;
    private Coord playerPosition;
    private Direction playerFacing;

    public GridArea getGridArea() {
        return gridArea;
    }

    public void setGridArea(GridArea gridArea) {
        this.gridArea = gridArea;
    }

    public Coord getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Coord playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Direction getPlayerFacing() {
        return playerFacing;
    }

    public void setPlayerFacing(Direction playerFacing) {
        this.playerFacing = playerFacing;
    }
}
