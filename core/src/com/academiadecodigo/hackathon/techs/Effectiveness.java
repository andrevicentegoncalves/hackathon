package com.academiadecodigo.hackathon.techs;

public enum Effectiveness {
    SUPER,
    NORMAL,
    POOR,
    IMMUNE;

    public static double multiplier(Effectiveness effectiveness) {
        switch (effectiveness) {
            case SUPER:
                return 2;
            case POOR:
                return 1/2;
            case IMMUNE:
                return 0;
            default:
                return 1;
        }
    }

}
