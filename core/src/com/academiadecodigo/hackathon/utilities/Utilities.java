package com.academiadecodigo.hackathon.utilities;

public class Utilities {

    /**
     * Returns a number from 1 to "max"
     * @param max
     * @return
     */
    public static int roll(int max) {
        return (int) Math.ceil(Math.random()*max);
    }

    /**
     * Returns a random name from a pool of names (currently 15 different names)
     * @return
     */
    public static String genNames () {
        int x = roll(33);
        switch (x) {
            case 1:
                return "Alfred";
            case 2:
                return "Bartuc";
            case 3:
                return "Carl";
            case 4:
                return "Damien";
            case 5:
                return "Edward";
            case 6:
                return "Fandral";
            case 7:
                return "Gabriel";
            case 8:
                return "Hilter";
            case 9:
                return "Ingrid";
            case 10:
                return "Jake";
            case 11:
                return "Kendra";
            case 12:
                return "Lamar";
            case 13:
                return "Marcus";
            case 14:
                return "Nemes";
            case 15:
                return "Oswald";
            case 16:
                return "Patrick";
            case 17:
                return "Q-bert";
            case 18:
                return "Richard";
            case 19:
                return "Saul";
            case 20:
                return "Taya";
            case 21:
                return "Ulfred";
            case 22:
                return "Vlad";
            case 23:
                return "Wendy";
            case 24:
                return "Xander";
            case 25:
                return "Yennifer";
            case 26:
                return "Zelgadis";
            case 27:
                return "Asgore";
            case 28:
                return "Balore";
            case 29:
                return "Cassiopeia";
            case 30:
                return "Dio";
            case 31:
                return "Erik";
            case 32:
                return "Flubber";
            case 33:
                return "Geralt";
                //More cases? maybe

            default:
                return "a sad person";
        }
        //return "";
    }

}
