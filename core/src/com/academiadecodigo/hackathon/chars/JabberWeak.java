package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.techs.general.Attack;
import com.academiadecodigo.hackathon.utilities.Utilities;

import java.util.HashSet;

public class JabberWeak extends Character {

    public static Character genWeakJabber() {
        int random = (int) Math.ceil(Math.random()*3);
        Character c = new JabberWeak();
        c.setHpMax(20);
        c.setHp(19);
        c.setFighterType(TechType.JAB);
        c.setName(Utilities.genNames());
        c.setMoves(new HashSet<Tech>(4));
        switch (random) {
            case 1:
                c.getMoves().add(Attack.createAttack("Weak Jab", 5, 0, TechType.JAB));
                c.getMoves().add(Attack.createAttack("Back In My Days", 1, 0, TechType.SOUND));
                c.getMoves().add(Attack.createAttack("Drool", 1, 0, TechType.PSY));
                break;
            case 2:
                c.getMoves().add(Attack.createAttack("Weak Jab", 5, 0, TechType.JAB));
                c.getMoves().add(Attack.createAttack("Nag", 3, 0, TechType.SOUND));
                c.getMoves().add(Attack.createAttack("Stare", 1, 0, TechType.PSY));
                break;
            default:
                c.getMoves().add(Attack.createAttack("Weak Jab", 5, 0, TechType.JAB));
                break;
        }
        return c;
    }

}
