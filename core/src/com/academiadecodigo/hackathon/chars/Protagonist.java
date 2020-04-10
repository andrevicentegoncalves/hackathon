package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.techs.general.Attack;

public class Protagonist extends Person {

    private int enemiesDefeated;

    public Protagonist() {
        super();
        getMoves().add(Attack.createAttack("Indian Burn", 3, 0, TechType.FRICTION));
        getMoves().add(Attack.createAttack("Toss Nugget", 7, 0, TechType.SMACK));
        getMoves().add(Attack.createAttack("Steal Walking Cane", 4, 0, TechType.GRAPPLE));
    }

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
