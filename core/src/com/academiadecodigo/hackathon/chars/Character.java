package com.academiadecodigo.hackathon.chars;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;

import java.util.Set;

public abstract class Character {

    private Integer id;
    private String name;
    private Set<Tech> moves;
    private TechType fighterType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
