package com.academiadecodigo.hackathon.view;

import com.academiadecodigo.hackathon.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class GameView implements Screen {

    private final Game game;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;
    private Sprite sprite;
    private SpriteBatch sb;

    public GameView(final Game game, OrthographicCamera camera, TiledMapRenderer tiledMapRenderer, Sprite sprite, SpriteBatch sb) {
        this.game = game;
        this.camera = camera;
        this.tiledMapRenderer = tiledMapRenderer;
        this.sprite = sprite;
        this.sb = sb;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.19f, 0.19f, 0.19f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        /*Dialog dialog = new Dialog("teste", new Window.WindowStyle());
        dialog.text("You can't fight me now!");*/


        sb.begin();
        sprite.draw(sb);
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
