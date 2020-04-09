package com.academiadecodigo.hackathon.visuals;

import com.academiadecodigo.hackathon.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;


public class TopDownCamera implements InputProcessor {

    private Game game;

    private OrthographicCamera camera;
    private TiledMap tiledMap;

    private boolean activeOverworld;
    private boolean activeBattle;

    public TopDownCamera(Game game, OrthographicCamera camera, TiledMap tiledMap) {
        this.game = game;
        this.camera = camera;
        this.tiledMap = tiledMap;
    }

    @Override
    public boolean keyDown(int keycode) {
        //Overworld keys active
        if (isActiveOverworld()) { //Key inputs for walking in the gridworld here
            if (keycode == Input.Keys.LEFT)
                camera.translate(-32, 0);
            if (keycode == Input.Keys.RIGHT)
                camera.translate(32, 0);
            if (keycode == Input.Keys.UP)
                camera.translate(0, 32);
            if (keycode == Input.Keys.DOWN)
                camera.translate(0, -32);
            if (keycode == Input.Keys.NUM_1)
                tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
            if (keycode == Input.Keys.NUM_2)
                tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
            if (keycode == Input.Keys.X)
                game.triggerBattle(); //Initiates combat mode

            return true;
        }
        //Battle keys active
        if (isActiveBattle()) { //Key inputs for battle view go here.
            if (keycode == Input.Keys.X)
                game.finishBattle();

            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isActiveOverworld() {
        return activeOverworld;
    }

    public void setActiveOverworld(boolean activeOverworld) {
        this.activeOverworld = activeOverworld;
    }

    public boolean isActiveBattle() {
        return activeBattle;
    }

    public void setActiveBattle(boolean activeBattle) {
        this.activeBattle = activeBattle;
    }
}
