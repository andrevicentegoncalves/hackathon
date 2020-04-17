package com.academiadecodigo.hackathon.world;

public class PlayerMovement {

    public static boolean move(Direction direction, Coord from, GridArea area) {
        switch (direction) {
            case UP:
                if (from.getY() < area.getHeight()) {

                }
                break;
        }
        return true;
    }

}
