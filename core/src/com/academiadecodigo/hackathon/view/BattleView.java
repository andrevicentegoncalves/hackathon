package com.academiadecodigo.hackathon.view;

import com.academiadecodigo.hackathon.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class BattleView implements Screen {

    private final Game game;
    private Texture img;
    private Rectangle player;
    SpriteBatch sb;
    BitmapFont font;
    ShapeRenderer sp;

    public BattleView(final Game game, SpriteBatch sb, BitmapFont font) {
        this.game = game;
        this.sb = sb;
        this.font = font;
        sp = new ShapeRenderer();
    }

    @Override
    public void show() {

        player = new Rectangle();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sp.begin(ShapeRenderer.ShapeType.Filled);
        sp.setColor(Color.WHITE);
        sp.rect(315,125,105,50);
        sp.end();
        sb.begin();
        font.draw(sb,"FUUUUUUCK",320,160);
        sb.end();
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
