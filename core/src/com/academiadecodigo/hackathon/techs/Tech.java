package com.academiadecodigo.hackathon.techs;

import java.util.Objects;

public abstract class Tech {

    private String name;
    private int power;
    private int cooldown = 0;
    private TechType techType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public TechType getTechType() {
        return techType;
    }

    public void setTechType(TechType techType) {
        this.techType = techType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tech tech = (Tech) o;
        return power == tech.power &&
                cooldown == tech.cooldown &&
                techType == tech.techType;
    }

    //TODO: check this hash issue for android
    @Override
    public int hashCode() {
        return Objects.hash(power, cooldown, techType);
    }
}
