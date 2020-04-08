package com.academiadecodigo.hackathon.battle;

import com.academiadecodigo.hackathon.chars.Person;
import com.academiadecodigo.hackathon.techs.Effectiveness;
import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.techs.general.Attack;
import com.academiadecodigo.hackathon.utilities.Utilities;

public class Battle {
    private Person player;
    private Person enemy;

    private Attack playerAttack;
    private Attack enemyAttack;

    private int backgroundId;
    private boolean victory = false;
    private boolean defeat = false;

    public void resolveTurn() {
        if (player.isAlive()) {
            enemy.setHp((int) Math.max(0,
                    enemy.getHp() -
                            Effectiveness.multiplier(TechType.effect(playerAttack.getTechType(),enemy.getFighterType()))*
                                    (playerAttack.getPower() - (Math.floor(Utilities.roll(playerAttack.getPower()/3))) )) );
        }
        if (enemy.isAlive()) {
            player.setHp((int) Math.max(0,
                    enemy.getHp() -
                            Effectiveness.multiplier(TechType.effect(enemyAttack.getTechType(),player.getFighterType()))*
                                    (playerAttack.getPower() - (Math.floor(Utilities.roll(playerAttack.getPower()/4))) )) );
            if (!player.isAlive()) defeat = true;
        }
        else victory = true;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Person getEnemy() {
        return enemy;
    }

    public void setEnemy(Person enemy) {
        this.enemy = enemy;
    }

    public Attack getPlayerAttack() {
        return playerAttack;
    }

    public void setPlayerAttack(Attack playerAttack) {
        this.playerAttack = playerAttack;
    }

    public Attack getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(Attack enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public boolean isDefeat() {
        return defeat;
    }

    public void setDefeat(boolean defeat) {
        this.defeat = defeat;
    }



}
