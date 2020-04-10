package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.techs.general.Attack;

import java.util.ArrayList;

public class Person {

    private Integer imageId;
    private String name;
    private ArrayList<Attack> moves;
    private TechType fighterType;

    private int hpMax;
    private int hp;

    public Person() {
        imageId = 0;
        name = "Generics";
        moves = new ArrayList<>();
        moves.add(Attack.createAttack("Bland", 10, 0, TechType.KI) );
        fighterType = TechType.KI;

        hpMax = 30;
        hp = hpMax;

    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attack> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Attack> moves) {
        this.moves = moves;
    }

    public Attack getMove(int num) {
        if (num < moves.size()) return moves.get(num);
        else return moves.get(0);
    }

    public TechType getFighterType() {
        return fighterType;
    }

    public void setFighterType(TechType fighterType) {
        this.fighterType = fighterType;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHp() {
        return hp;
    }

    public void decreaseHp(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

}
