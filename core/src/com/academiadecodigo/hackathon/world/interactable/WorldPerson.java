package com.academiadecodigo.hackathon.world.interactable;

import java.util.ArrayList;

public class WorldPerson implements Interactable {

    ArrayList<String> messages;

    @Override
    public String message(int which) {
        if (which >= messages.size()) return "Someone asked for a line I don't have! " +
                "\nBut no array out of bounds will kill this game on my watch!";
        return messages.get(which);
    }


}
