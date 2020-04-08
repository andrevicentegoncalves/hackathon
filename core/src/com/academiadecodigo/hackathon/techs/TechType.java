package com.academiadecodigo.hackathon.techs;

public enum TechType {
    SMACK,
    JAB,
    FRICTION,
    GRAPPLE,
    KI,
    PSY,
    SOUND;

    public static Effectiveness effect(TechType attack, TechType defender) {
        switch (attack) {
            case SMACK:
            case JAB:
                switch (defender) {
                    case FRICTION:
                    case GRAPPLE:
                        return Effectiveness.SUPER;
                    case KI:
                    case PSY:
                    case SOUND:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            case FRICTION:
                switch (defender) {
                    case KI:
                        return Effectiveness.IMMUNE;
                    case FRICTION:
                    case SOUND:
                        return Effectiveness.SUPER;
                    case GRAPPLE:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            case GRAPPLE:
                switch (defender) {
                    case GRAPPLE:
                        return Effectiveness.IMMUNE;
                    case SMACK:
                        return Effectiveness.SUPER;
                    case JAB:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            case KI:
                switch (defender) {
                    case SMACK:
                    case JAB:
                        return Effectiveness.SUPER;
                    case KI:
                    case SOUND:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            case PSY:
                switch (defender) {
                    case GRAPPLE:
                        return Effectiveness.IMMUNE;
                    case FRICTION:
                    case JAB:
                    case SMACK:
                        return Effectiveness.SUPER;
                    case KI:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            case SOUND:
                switch (defender) {
                    case SOUND:
                    case PSY:
                        return Effectiveness.SUPER;
                    case FRICTION:
                    case JAB:
                        return Effectiveness.POOR;
                    default:
                        return Effectiveness.NORMAL;
                }
            default:
                return Effectiveness.NORMAL;
        }

    }
}
