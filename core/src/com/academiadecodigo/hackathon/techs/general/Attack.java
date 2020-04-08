package com.academiadecodigo.hackathon.techs.general;

import com.academiadecodigo.hackathon.techs.Tech;
import com.academiadecodigo.hackathon.techs.TechType;
import com.academiadecodigo.hackathon.utilities.Utilities;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class Attack extends Tech {
    public Attack() {
        this.setCooldown(0);
    }

    public static Attack createAttack(String name, int power, int cooldown, TechType techType) {
        Attack newAttack = new Attack();
        newAttack.setName(name);
        newAttack.setPower(power);
        newAttack.setCooldown(cooldown);
        newAttack.setTechType(techType);
        return newAttack;
    }

    public static Attack genAttackFromVictory(Attack source) {
        Attack gen = new Attack();
        gen.setTechType(source.getTechType());
        gen.setCooldown(source.getCooldown());
        StringBuilder sb = new StringBuilder(source.getName());
        if ( Character.isDigit( sb.charAt(sb.lastIndexOf(sb.toString()))) ) {
            int num = Integer.valueOf(sb.charAt(sb.lastIndexOf(sb.toString())));
            num++;
            if (num < 10) {
                sb.replace(sb.lastIndexOf(sb.toString()), sb.lastIndexOf(sb.toString()) + 1, String.valueOf(num));
                gen.setPower(source.getPower() + Utilities.roll(20));
            }
            else gen.setPower(source.getPower());
        }
        else sb.append("+1");
        gen.setName(sb.toString());
        return gen;
    }

}
