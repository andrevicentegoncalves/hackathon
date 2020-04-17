package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.techs.general.Attack;
import com.academiadecodigo.hackathon.utilities.Utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class JabberWeak extends Person {

    public static Person genWeakJabber() {
        int random = (int) Math.ceil(Math.random()*6);
        Person c = new JabberWeak();
        c.setHpMax(30);
        c.setHp(28);
        c.setFighterType(TechType.JAB);
        c.setName(Utilities.genNames());
        c.setMoves(new ArrayList<Attack>(4));
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
            case 3:
                c.getMoves().add(Attack.createAttack("Old Fart", 5, 0, TechType.PSY));
                c.getMoves().add(Attack.createAttack("Back In My Days", 1, 0, TechType.SOUND));
                c.getMoves().add(Attack.createAttack("Grandma's Meal", 0, 0, TechType.PSY));
            case 4:
                c.getMoves().add(Attack.createAttack("Wave Walking Stick", 4, 0, TechType.SMACK));
                c.getMoves().add(Attack.createAttack("Spitle", 4, 0, TechType.KI));
                c.getMoves().add(Attack.createAttack("Use Viagra", 4, 0, TechType.GRAPPLE));
            default:
                c.getMoves().add(Attack.createAttack("Weak Jab", 7, 0, TechType.JAB));
                break;
        }
        return c;
    }

}
