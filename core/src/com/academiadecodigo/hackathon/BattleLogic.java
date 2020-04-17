package com.academiadecodigo.hackathon;

import com.academiadecodigo.hackathon.battle.Battle;
import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.general.Attack;
import com.academiadecodigo.hackathon.utilities.Utilities;

import java.util.ArrayList;
import java.util.Set;

public class BattleLogic {

    private Game game;
    private Battle scenario;

    public BattleLogic(Battle scenario, Game game) {
        this.scenario = scenario;
        this.game = game;
    }

    public void logicLoop(int num) {
        //while (scenario.isVictory() && !scenario.isDefeat()) {
            promptPlayerForAttack(num);
            chooseEnemyAttack();
            scenario.resolveTurn();
        //}
        if (scenario.isVictory()) {
            showVicotry();
        }
        else showDefeat();
    }

    public void promptPlayerForAttack(int num) {
        scenario.setPlayerAttack(scenario.getPlayer().getMove(num));
    }

    public void chooseEnemyAttack() {
        ArrayList<Attack> moves = scenario.getEnemy().getMoves();
        int rand = Utilities.roll(moves.size()) - 1; //This is because roll goes from 1 to Max
        scenario.setEnemyAttack((Attack) moves.toArray()[rand]); //WARNING: cast an attack, decide if Tech should replace Attack or vice-versa.
    }

    public void showVicotry() {
        //TODO!
    }

    public void showDefeat() {
        //TODO!
    }

    public Battle getScenario() {
        return scenario;
    }

    public void setScenario(Battle scenario) {
        this.scenario = scenario;
    }

    public Game getGame() {
        return game;
    }
}
