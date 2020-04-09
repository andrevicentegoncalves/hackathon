package com.academiadecodigo.hackathon.view;

import com.academiadecodigo.hackathon.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BattleView implements Screen {

    private final Game game;
    Texture img;
    Rectangle player;

    public BattleView(final Game game) {
        this.game = game;
    }

    @Override
    public void show() {

        img = new Texture(Gdx.files.internal("background.jpg"));
        player = new Rectangle();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
