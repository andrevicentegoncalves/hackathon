package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;

import java.util.Set;

public class Person {

    private Integer imageId;
    private String name;
    private Set<Tech> moves;
    private TechType fighterType;

    private int hpMax;
    private int hp;


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

    public Set<Tech> getMoves() {
        return moves;
    }

    public void setMoves(Set<Tech> moves) {
        this.moves = moves;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

}
