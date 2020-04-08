package com.academiadecodigo.hackathon.chars;

public class Protagonist extends Person {

    private int enemiesDefeated;

    public void incrementKillCounter() {
        enemiesDefeated++;
    }

    public int getEnemiesDefeated() {
        return enemiesDefeated;
    }

    public void setEnemiesDefeated(int enemiesDefeated) {
        this.enemiesDefeated = enemiesDefeated;
    }
}
