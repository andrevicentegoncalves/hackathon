package com.academiadecodigo.hackathon;

import com.academiadecodigo.hackathon.battle.Battle;
import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.general.Attack;
import com.academiadecodigo.hackathon.utilities.Utilities;

import java.util.Set;

public class BattleLogic {

    private Battle scenario;

    public void logicLoop() {
        while (!scenario.isVictory() && !scenario.isDefeat()) {
            promptPlayerForAttack();
            chooseEnemyAttack();
            scenario.resolveTurn();
        }
        if (scenario.isVictory()) {
            showVicotry();
        }
        else showDefeat();
    }

    public void promptPlayerForAttack() {
        //TODO!
    }

    public void chooseEnemyAttack() {
        Set<Tech> moves = scenario.getEnemy().getMoves();
        int rand = Utilities.roll(moves.size());
        scenario.setEnemyAttack((Attack) moves.toArray()[rand]); //WARNING: cast an attack, decide if Tech should replace Attack or vice-versa.
    }

    public void showVicotry() {
        //TODO!
    }

    public void showDefeat() {
        //TODO!
    }

}
